package com.acme.model;

public class Main {

	public static void main(String[] args) {
		Product p1 = new Product("1", "dentifricio", 2.3, ProductType.OTHER );
		System.out.println(p1);
		
		Product p2 = new Product("2", "pentola", 44.2, ProductType.OTHER);
		System.out.println(p2);
		
		Ticket t = new Ticket();
		t.register(p1);
		t.register(p2);
		
		System.out.println(t);
	}
}
