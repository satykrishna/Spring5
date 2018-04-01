package spring.aspect.introductions.service.impl;

import org.apache.log4j.Logger;

import static org.Spring.java8.util.AppLogger.*;
import static org.apache.log4j.Level.*;


import spring.aspect.introductions.service.MinCalculator;

public class MinCalculatorImpl implements MinCalculator {
	
	private static final Logger logger = 
			Logger.getLogger(MinCalculatorImpl.class);

	@Override
	public double min(double a, double b) {
		double result = (a <=b)?a:b;
		log(logger, INFO, ()->"min(" + a + ", " + b + ") = " + result);
		return result;
	}

}
