package com.acme.model.impl;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.acme.model.BuyManager;
import com.acme.model.Product;
import com.acme.model.ProductManager;
import com.acme.model.ShoppingCartManager;

// Facade: it coordinates more than one business object
// exposing "atomic" methods.
@ApplicationScoped
public class DefaultBuyManager implements BuyManager {
	@Inject
	private ShoppingCartManager shm;
	
	@Inject // @Named("dpm")
	private ProductManager pm;
	
	@Override
	public List<Product> buyProduct(String id) {
		pm.findProductById(id).ifPresent(shm::buyProduct);
		return shm.getAllProducts();
	}
}
