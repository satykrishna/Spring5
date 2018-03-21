package org.Spring.model;

public class Battery extends Product {

	private boolean reachargable;
	
	public Battery(String name, double price, boolean reachargable) {
		super(name, price);
		this.reachargable = reachargable;
	}

	public boolean isReachargable() {
		return reachargable;
	}

	public void setReachargable(boolean reachargable) {
		this.reachargable = reachargable;
	}

	public Battery(String name, double price) {
		super(name, price);
	}

	public Battery() {
		// TODO Auto-generated constructor stub
	}

}
