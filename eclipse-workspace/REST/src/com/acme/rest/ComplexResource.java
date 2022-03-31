package com.acme.rest;

import javax.xml.bind.annotation.XmlAttribute; // JAXB
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ComplexResource {
	private int i;
	private String s1;
	private String s2;
	
	public ComplexResource() { // required
	}

	public ComplexResource(int i, String s1, String s2) {
		this.i = i;
		this.s1 = s1;
		this.s2 = s2;
	}
	
	// below required
	@XmlAttribute(name="id")
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}	
}
