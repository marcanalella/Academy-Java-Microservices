package com.acme.model;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

	List<Product> getAllProducts();

	void insertProduct(Product product);

	Optional<Product> findProductById(String id);

}
