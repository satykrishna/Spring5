package spring.aspect.service.impl;

import static org.Spring.java8.util.AppLogger.*;
import static org.apache.log4j.Level.*;


import org.Spring.model.Complex;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import spring.aspect.service.ComplexArithmetic;

@Component("complexCalculator")
public class ComplexArithmeticImpl implements ComplexArithmetic {

	private static final Logger logger = 
			Logger.getLogger(ComplexArithmeticImpl.class);
			
	@Override
	public Complex add(Complex a, Complex b) {
		int real = a.getReal() + b.getReal();
		int imaginary = a.getImaginary() + b.getImaginary();
		Complex result = new Complex(real, imaginary);
		log(logger, INFO, ()->"ADD " + a.toString() + "& " + b.toString() +"="+ result.toString());
		return result;
	}

	@Override
	public Complex sub(Complex a, Complex b) {
		int real = a.getReal() - b.getReal();
		int imaginary = a.getImaginary() - b.getImaginary();
		Complex result = new Complex(real, imaginary);
		log(logger, INFO, ()->"SUB " + a.toString() + "& " + b.toString() +"="+ result.toString());
		return result;
	}

}
