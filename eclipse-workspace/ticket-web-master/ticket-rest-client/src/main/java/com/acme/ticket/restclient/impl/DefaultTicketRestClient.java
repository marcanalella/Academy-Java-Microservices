package com.acme.ticket.restclient.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.acme.jaxb.ProductJaxb;
import com.acme.jaxb.ProductsJaxb;
import com.acme.model.Product;
import com.acme.ticket.restclient.TicketRestClient;

public class DefaultTicketRestClient implements TicketRestClient {

	@Override
	public List<Product> getAllProducts() {
		Response r = ClientBuilder.newClient().target("http://localhost:8080/ticket-web/rest/product").request()
//			     .accept(MediaType.APPLICATION_XML)
				.get();
		
		if (r.getStatus() != 200) {
			throw new RuntimeException("HTTP Status: " + r.getStatus());
		}

//		MultivaluedMap<String, Object> h = r.getHeaders();
//		System.out.println("status: " + r.getStatus());
//		System.out.println("headers: " + h);
		ProductsJaxb e = r.readEntity(ProductsJaxb.class);
		return e.getProducts().stream()
							  .map(ProductJaxb::toProduct)
					          .collect(Collectors.toList());
	}
}
