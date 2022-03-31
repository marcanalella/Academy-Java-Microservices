package com.acme.ticket.restclient.impl;

import java.util.List;

import org.junit.Test;

import com.acme.model.Product;
import com.acme.ticket.restclient.TicketRestClient;

public class DefaultTicketRestClientTest {
	@Test
	public void testGetAllProducts() {
		// GIVEN
		TicketRestClient underTest = new DefaultTicketRestClient();
		// WHEN
		List<Product> actualResult = underTest.getAllProducts();
		// THEN
		System.out.println(actualResult);
		// TODO: compare actualResult with an expectedResult
	}
}
