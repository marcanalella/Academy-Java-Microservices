package com.acme.model.impl;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.acme.model.Product;
import com.acme.model.ProductDao;
import com.acme.model.ProductManager;

@Component
@Transactional
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
