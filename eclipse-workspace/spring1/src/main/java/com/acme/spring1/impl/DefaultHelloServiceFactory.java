package com.acme.spring1.impl;

import com.acme.spring1.HelloService;

public class DefaultHelloServiceFactory {
	
	public HelloService createHelloService() {
		System.out.println("FACTORY");
		return new DefaultHelloService();
	}

}
