package com.acme.cars;

public class RX8Engine implements Engine {
	
	public void accelerate(double d) {
		System.out.println("accelerate RX8 " + d);
	}

	public double computeTorque() {
		return 7; // complex computation
	}
}
