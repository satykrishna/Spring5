package org.Spring.model;

public class Disc extends Product {

	private int capacity;

	public Disc(String name, double price, int capacity) {
		super(name, price);
		this.capacity = capacity;
	}

	public Disc(String name, double price) {
		super(name, price);
	}

	public Disc() {
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
