package com.acme.cars;

public class JBAstonMartinCar 
	extends AbstractCar
	implements Shooter {

	private Engine engine = new GenericEngine();
	
	public void pushPedal(double d) {
		engine.accelerate(d);
	}

	public void turnSteer(double d) {
		System.out.println("steer " + d);
	}

	public void shoot() {
		System.out.println("shoot");		
	}
}
