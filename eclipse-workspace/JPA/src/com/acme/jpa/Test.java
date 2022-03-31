package com.acme.jpa;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class Test {
	@Inject
	private CarDao dao;
	@GET
	public String doSomething() {
		Car car = new Car();
//		car.setId(1);
		car.setMaker("Audi");
		car.setModel("A3");
		dao.insert(car);
		
		car = new Car(); // 2
//		car.setId(2);
		car.setMaker("Audi");
		car.setModel("A4");
		dao.insert(car);
		
		car = new Car();
//		car.setId(3);
		car.setMaker("Ford");
		car.setModel("Fiesta");
		dao.insert(car);
		
		
//		dao.updateModel(2, "A5");
		Car carToUpdate = dao.findById(2);
		carToUpdate.setModel("A5");
		dao.update(carToUpdate);
		
		
		return dao.findByMaker("Audi").toString();
		
//		car = dao.findById(1);
//		return car.toString();
	}
}
