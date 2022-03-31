package com.acme.model.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

import com.acme.model.Product;
import com.acme.model.ProductManager;
import com.acme.model.ProductType;

@ApplicationScoped
//@RequestScoped
public class MockProductManager implements ProductManager {

	private List<Product> products = new ArrayList<>();
	
	private AtomicInteger keyGenerator = new AtomicInteger(1);

	// TODO: demonstrate constructors in components are evil
	@PostConstruct
	private void initialize() {
		System.out.println("MockProductManager postconstruct");
		addProduct(new Product("Moby Dick", 5.4, ProductType.BOOK, ProductType.EBOOK));
		addProduct(new Product("Toothpaste", 0.5, ProductType.OTHER));
		addProduct(new Product("Paper", 2.0, ProductType.OTHER));
	}
	
	@PreDestroy
	private void shutdown() {
		System.out.println("MockProductManager predestroy");
	}
	
	@Override
	public List<Product> getAllProducts() {
//		return new ArrayList<>(products);
//		return Collections.unmodifiableList(products);
		return new CopyOnWriteArrayList<>(products);
	}
	
	@Override
	public void addProduct(Product product) {
		String id = Integer.toString(keyGenerator.getAndIncrement());
		products.add(product.withId(id));
	}

	@Override
	public Optional<Product> findProductById(String id) {
		return products.stream().filter(p -> p.getId().equals(id))
								.findFirst();
	}
}
