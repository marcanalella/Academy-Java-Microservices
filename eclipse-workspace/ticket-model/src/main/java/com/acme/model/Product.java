package com.acme.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Product {
	
	private final Optional<String> id;
	
	private final String name;
	
	private final double price;
	
	private final List<ProductType> types;
	
	public Product (String n, double p, ProductType... types) { // ProductType[]
		id = Optional.empty();
		name = n;
		price = p;
		this.types = Arrays.asList(types);
	}
	
	public Product (String i, String n, double p, ProductType... types) {
		id = Optional.of(i);
		name = n;
		price = p;
		this.types = Arrays.asList(types);
	}
	
	public Product (String i, String n, double p, List<ProductType> types) {
		id = Optional.ofNullable(i);
		name = n;
		price = p;
		this.types = types;
	}
	
	public String getId() {
		return id.get();
	}
	
//	public Optional<String> getOptionalId() {
//		return id;
//	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() { // convenzione: metodo "getter"
		return price;
	}
	
	public List<ProductType> getTypes() {
		return types;
	}
	
	public String toString() {
		return String.format("Product(%s, %s, %s, %s)", id, name, price, types);
	}

	public Product withId(String id) {
		return new Product(id, name, price, types);
	}
}
