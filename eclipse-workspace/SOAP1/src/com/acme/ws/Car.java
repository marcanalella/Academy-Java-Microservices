package com.acme.ws;

import javax.xml.bind.annotation.XmlElement;

public class Car {
	
	private int id;
	
	private String maker;
	
	private String model;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	@XmlElement(name="name")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
