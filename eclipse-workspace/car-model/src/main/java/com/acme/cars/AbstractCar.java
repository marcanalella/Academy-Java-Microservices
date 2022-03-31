package com.acme.cars;

public abstract class AbstractCar implements Car {

	protected double mass;
	
	protected double enginePower;
	
	protected double x, y, z;

	public void turnOn() {
		System.out.println("started");
	}

	public void turnOff() {
		System.out.println("stopped");
	}
	
	public void pushBrakePedal(double d) {
		System.out.println("brake " + d);
	}	
}
