package com.acme.cars;

public interface Player {

	void getOn(Car car);

	void turnOnEngine();

	void accelerate(double d);

	void brake(double d);

	void turnOffEngine();

	void getOff();

	void turnSteer(double d);

	void shoot();

}
