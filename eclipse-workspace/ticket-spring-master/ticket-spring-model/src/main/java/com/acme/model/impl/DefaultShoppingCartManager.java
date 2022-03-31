package com.acme.model.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

//import org.springframework.context.annotation.Scope;
//import org.springframework.web.context.annotation.SessionScope;
import com.acme.model.Product;
import com.acme.model.ShoppingCartManager;

@Component
@SessionScope
public class DefaultShoppingCartManager 
	implements ShoppingCartManager, Serializable {

	// transient because WidlFly requires Serialization, 
	// but we don't bother
	private List<Product> products; // = new ArrayList<>();
	
	@PostConstruct
	private void initialize() {
		products = new ArrayList<>();
		System.out.printf("DefaultShoppingCartManager postcontruct %s\n", this);
	}
	
	@PreDestroy
	private void shutdown() {
		System.out.printf("DefaultShoppingCartManager predestroy %s\n", this);
	}
	
	@Override
	public void buyProduct(Product product) {
		products.add(product);
		System.out.printf("%s - products: %s\n", this, products);
	}

	@Override
	public List<Product> getAllProducts() {
		return new CopyOnWriteArrayList<>(products);
	}
}
