package com.acme.model;

public class Ticket {
	
	private double sum;
	
	public void register (Product p) {
		sum += p.getPrice();
	}
	
	public String toString() {
		return "Ticket " + sum;
	}

}
