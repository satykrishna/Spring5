package spring.aspect.introductions.service.impl;

import spring.aspect.introductions.service.MaxCalculator;
import static org.spring.java8.util.AppLogger.*;
import static org.apache.log4j.Level.*;

import org.apache.log4j.Logger;

public class MaxCalculatorImpl implements MaxCalculator {
	
	private static Logger logger = Logger.getLogger(MaxCalculatorImpl.class);

	@Override
	public double max(double a, double b) {
		double result = (a >=b)? a:b;
		log(logger, INFO, ()->"max(" + a + ", " + b + ") = " + result);
		return result;
	}

}
