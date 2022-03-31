package com.acme.model.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.acme.jpa.ProductJpa;
import com.acme.jpa.ProductTypeJpa;
import com.acme.model.Product;
import com.acme.model.ProductDao;

@Singleton
@TransactionAttribute
public class JpaProductDao implements ProductDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Product> getAllProducts() {
		String q = "SELECT p FROM ProductJpa p";
		return em.createQuery(q, ProductJpa.class)
				 .getResultList()
				 .stream()
				 .map(ProductJpa::toProduct)
				 .collect(Collectors.toList());
	}

	@Override
	public void insertProduct(Product product) {
		ProductJpa pj = ProductJpa.fromProduct(product);
		List<ProductTypeJpa> ptjs = pj.getTypes().stream()
				.map(this::persistOrReplaceWithExisting)
                .collect(Collectors.toList());
		pj.setTypes(ptjs);
		em.persist(pj);		
	}

	private ProductTypeJpa persistOrReplaceWithExisting(ProductTypeJpa ptj) {
		try {
			String q = "SELECT t FROM ProductTypeJpa t WHERE t.name = :name";
			ProductTypeJpa existingType = em.createQuery(q, ProductTypeJpa.class)
					 .setParameter("name", ptj.getName())
					 .getSingleResult();
			// must create relationship to existing object
			return existingType;
		} catch (NoResultException e) {
			em.persist(ptj);
			return ptj;
		}
	}

	@Override
	public Optional<Product> findProductById(String id) {
		return Optional.ofNullable(em.find(ProductJpa.class, 
										   Integer.parseInt(id)))
					   .map(ProductJpa::toProduct);
	}

}
