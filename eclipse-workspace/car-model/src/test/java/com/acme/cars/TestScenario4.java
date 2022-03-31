package com.acme.cars;

public class TestScenario4 {

	public static void main(String[] args) {
		Car car = new JBAstonMartinCar();
		Player driver = new GenericPlayer();
		
		driver.getOn(car);
		driver.turnOnEngine();
		driver.accelerate(0.3);
		// wait 10 seconds
		driver.turnSteer(+0.4);
		driver.shoot();
		// wait 10 seconds
		driver.brake(1.0);
		driver.turnOffEngine();
		driver.getOff();
		// should check the car is at a certain position
	}
}
