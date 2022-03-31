package com.acme.model;

import java.util.List;
import java.util.Optional;

import com.acme.model.Product;

public interface ProductManager {

	List<Product> getAllProducts();

	void addProduct(Product product);

	Optional<Product> findProductById(String id);
}
