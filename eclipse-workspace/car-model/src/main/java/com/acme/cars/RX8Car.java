package com.acme.cars;

public class RX8Car extends AbstractCar {

	// composition
	private Engine engine = new RX8Engine();
	
	public void turnSteer(double d) {
		System.out.println("steer RX8 " + d);
	}

	// delegation
	public void pushPedal(double d) {
		engine.accelerate(d);
	}
}
