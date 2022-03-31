package com.acme.spring1.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import com.acme.spring1.HelloService;
import com.acme.spring1.NameService;

public class DefaultHelloService implements HelloService {

	@Inject // @AutoWired
	private NameService nameSvc;
	
	@PostConstruct
	private void init() {
		System.out.println("POST CONSTRUCT");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("PRE DESTROY");
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
