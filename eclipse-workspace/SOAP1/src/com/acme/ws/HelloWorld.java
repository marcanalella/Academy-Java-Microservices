package com.acme.ws;

import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace="http://example.acme.com")
//@ApplicationScoped
//@Singleton
public class HelloWorld {
	
	@WebMethod(operationName="hello")
	public String hello (@WebParam(name="name") String name) {
		System.out.println("WS: " + name);
		return "Hello " + name;
	}
//	@WebMethod(exclude=true)
	public Car hello2 (@WebParam(name="x") String x, 
						  @WebParam(name="y") int y, 
						  @WebParam(name="z") double z) {
		Car c = new Car();
		c.setId(3);
		c.setMaker("VW");
		c.setModel("Golf");
		return c;
	}
}
