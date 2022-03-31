package com.acme.spring1.impl;

import com.acme.spring1.HelloService;
import com.acme.spring1.NameService;

public class DefaultHelloService2 implements HelloService {

	private final NameService nameSvc;
	
	public DefaultHelloService2(NameService nameSvc) {
		this.nameSvc = nameSvc;
		System.out.println("CONSTRUCT");
	}
	
//	public NameService getNameSvc() {
//		return nameSvc;
//	}
//
//	public void setNameSvc(NameService nameSvc) {
//		this.nameSvc = nameSvc;
//	}

	public String getGreetings() {
		return "Hello " + nameSvc.getName();
	}

}
