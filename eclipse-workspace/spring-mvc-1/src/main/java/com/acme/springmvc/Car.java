package com.acme.springmvc;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car {
	private String maker;
	private String model;
	
	public Car() {
	}
	
	public Car(String maker, String model) {
		this.maker = maker;
		this.model = model;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}	
}
