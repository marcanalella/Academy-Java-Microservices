package com.acme.cars;

public class GenericPlayer implements Player {

	// composition; optional (no constructor)
	private Car car;

	public void getOn(Car car) {
		this.car = car;
	}

	public void getOff() {
		this.car = null; // this is redundant
	}

	public void turnOnEngine() {
		if (car != null) {
			car.turnOn();
		}
	}

	public void turnOffEngine() {
		if (car != null) {
			car.turnOff();
		}
	}

	public void accelerate(double d) {
		if (car != null) {
			car.pushPedal(d);
		}
	}

	public void brake(double d) {
		if (car != null) {
			car.pushBrakePedal(d);
		}
	}

	public void turnSteer(double d) {
		if (car != null) {
			car.turnSteer(d);
		}
	}

	public void shoot() {
		if (car != null) {
			if (car instanceof Shooter) {
				((Shooter) car).shoot();
			}
		}
	}
}
