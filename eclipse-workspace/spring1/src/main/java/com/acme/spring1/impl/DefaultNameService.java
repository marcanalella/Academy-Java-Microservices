package com.acme.spring1.impl;

import com.acme.spring1.NameService;

public class DefaultNameService implements NameService {

	private String name;
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
