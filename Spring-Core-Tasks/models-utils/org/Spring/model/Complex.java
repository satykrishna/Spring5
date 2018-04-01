package org.Spring.model;

public class Complex {

	private int real;
	private int imaginary;

	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImaginary() {
		return imaginary;
	}

	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}

	public Complex(int real, int imaginary) {
		super();
		this.real = real;
		this.imaginary = imaginary;
	}

	@Override
	public String toString() {
		return "Complex [real=" + real + ", imaginary=" + imaginary + "]";
	}
}
