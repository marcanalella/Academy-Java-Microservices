package com.acme.model.impl;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.acme.model.Product;
import com.acme.model.ProductType;

public class MongoProductDaoTest {

	@Test
	public void insertTest() {
		// GIVEN
		MongoProductDao underTest = new MongoProductDao();
		underTest.initialize();
		List<ProductType> types = new ArrayList<>();
		Product product = new Product("1", "Moby Dick", 44.2, types);
		// WHEN
		underTest.insertProduct(product);
		// THEN
		// TODO
		underTest.destroy();
	}
	
	@Test
	public void findTest() {
		// GIVEN
		MongoProductDao underTest = new MongoProductDao();
		underTest.initialize();
		// WHEN
		List<Product> result = underTest.getAllProducts();
		// THEN
		System.out.println("PRODUCTS " + result);
		underTest.destroy();
	}
}
