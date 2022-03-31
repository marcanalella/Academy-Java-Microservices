package com.acme.wsclient;

import java.util.Arrays;
import java.util.List;
import com.acme.ticket.wsclient.*;
import com.acme.ticket.wsclient.ProductJaxb.Types;

public class Main {

	public static void main(String[] args) {
		TicketWeb tw = new TicketWeb();
		ProductManager pm = tw.getProductManagerPort();
		initialize(pm);
		List<ProductJaxb> products = pm.getAllProducts();
		
		System.out.println("products: " + products);
		
		pm.getAllProducts().stream().forEach(
				p -> System.out.printf("%s %f %s\n", 
						p.getName(), p.getPrice(), p.getTypes().getType()));
	}
	
	private static void initialize(ProductManager pm) {
		addProduct(pm, "Moby Dick", 5.4, "BOOK", "EBOOK");
		addProduct(pm, "Toothpaste", 0.5, "OTHER");
		addProduct(pm, "Paper", 2.0, "OTHER");
	}

	private static void addProduct(ProductManager pm, String name, double price, String ... types) {
		ProductJaxb p = new ProductJaxb();
		p.setName(name);
		p.setPrice(price);
		Types t = new Types();
		t.getType().addAll(Arrays.asList(types));
		p.setTypes(t);
		pm.addProduct(p);
	}
			
}
