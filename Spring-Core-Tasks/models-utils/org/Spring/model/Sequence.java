package org.Spring.model;

public class Sequence {

	private  String id;
	private  String prefix;
	private  String suffix;

	public String getId() {
		return id;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public Sequence(String id, String prefix, String suffix) {
		super();
		this.id = id;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public Sequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Sequence [id=" + id + ", prefix=" + prefix + ", suffix=" + suffix + "]";
	}
	
	

}
