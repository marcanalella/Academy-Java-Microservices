package com.acme.ticket.restclient;

import java.util.List;
import com.acme.model.Product;

public interface TicketRestClient {
	
	public List<Product> getAllProducts();

}
