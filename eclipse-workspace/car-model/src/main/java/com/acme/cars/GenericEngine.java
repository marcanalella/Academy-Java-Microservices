package com.acme.cars;

public class GenericEngine implements Engine {

	public void accelerate(double d) {
		System.out.println("accelerate " + d);
	}

	public double computeTorque() {
		return 5; // complex computation
	}
}
