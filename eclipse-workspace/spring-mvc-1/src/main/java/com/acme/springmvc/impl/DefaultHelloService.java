package com.acme.springmvc.impl;

import com.acme.springmvc.HelloService;

public class DefaultHelloService implements HelloService {

	public String sayHello(String name) {
		return "Hello " + name;
	}
	
}
