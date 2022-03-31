package com.acme.cars;

public class GenericCar extends AbstractCar {
	
	// composition
	private Engine engine = new GenericEngine();
	
	public void turnSteer(double d) {
		System.out.println("steer " + d);
	}

	// delegation
	public void pushPedal(double d) {
		engine.accelerate(d);		
	}
}
