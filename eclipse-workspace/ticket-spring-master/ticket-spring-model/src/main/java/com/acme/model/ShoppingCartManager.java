package com.acme.model;

import java.util.List;

public interface ShoppingCartManager {

	void buyProduct(Product product);

	List<Product> getAllProducts();

}
