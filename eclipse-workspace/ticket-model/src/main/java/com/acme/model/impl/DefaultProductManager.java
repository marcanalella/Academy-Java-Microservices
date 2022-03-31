package com.acme.model.impl;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.inject.Named;

import com.acme.model.Product;
import com.acme.model.ProductDao;
import com.acme.model.ProductManager;
import com.acme.model.ProductType;

@Singleton
@TransactionAttribute
//@Named("dpm")
public class DefaultProductManager implements ProductManager {

	@Inject
	private ProductDao dao;
	
	@Override
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}
	
	@Override
	public void addProduct(Product product) {
		dao.insertProduct(product);
	}

	@Override
	public Optional<Product> findProductById(String id) {
		return dao.findProductById(id);
	}
}
