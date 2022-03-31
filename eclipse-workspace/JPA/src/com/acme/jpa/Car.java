package com.acme.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="CAR")
public class Car implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	private String maker;
	private String model;
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", maker=" + maker + ", model=" + model + "]";
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getMaker() {
		return this.maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}   
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, maker, model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Car))
			return false;
		Car other = (Car) obj;
		return id == other.id && Objects.equals(maker, other.maker) && Objects.equals(model, other.model);
	}
}
