package com.acme.apples;

import java.util.Objects;

public class Apple {
	
	private final String colour;
	
	private final double size;
	
	private final double weight;
	
	public Apple(String colour) {
		this(colour, 1, 1);
	}

	public Apple(String colour, double size) {
		this(colour, size, 1);
	}

	public Apple(String colour, double size, double weight) {
		this.colour = colour;
		this.size = size;
		this.weight = weight;
	}

	public String getColour() {
		return colour;
	}

	public double getSize() {
		return size;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colour, size, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		return Objects.equals(colour, other.colour)
				&& Double.doubleToLongBits(size) == Double.doubleToLongBits(other.size)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

	@Override
	public String toString() {
		return "Apple [colour=" + colour + ", size=" + size + ", weight=" + weight + "]";
	}
}
