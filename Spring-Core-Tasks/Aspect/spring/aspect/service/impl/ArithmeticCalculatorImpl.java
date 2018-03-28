package spring.aspect.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import spring.aspect.service.ArithmeticCalculator;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	private static final Logger logger = 
			Logger.getLogger(ArithmeticCalculatorImpl.class);
	
	@Override
	public double add(double a, double b) {
		double result = a + b;
		logger.info( a + " + " + b + " = " + result);
		return result;
	}

	@Override
	public double sub(double a, double b) {
		double result = a - b;
		logger.info( a + " - " + b + " = " + result);
		return result;
	}

	@Override
	public double mul(double a, double b) {
		double result = a * b;
		logger.info( a + "*" + b + " = " + result);
		return result;
	}

	@Override
	public double div(double a, double b) {
		if(b == 0) {
			throw new IllegalArgumentException("Division by Zero");
		}
		double result = a / b;
		logger.info( a + "/ " + b + " = " + result);
		return result;
	}

}
