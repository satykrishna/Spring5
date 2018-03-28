package spring.aspect.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import spring.aspect.service.UnitCalculator;

@Component("unitCalculator")
public class UnitCalculatorImpl implements UnitCalculator {

	private static final Logger logger = 
			Logger.getLogger(UnitCalculatorImpl.class);
	
	@Override
	public double kilogramToPound(double kilogram) {
		double pound = kilogram * 2.2;
        logger.info(kilogram + " kilogram = " + pound + " pound");
        return pound;
	}

	@Override
	public double kilometerToMile(double kilometer) {
		double mile = kilometer * 0.62;
		 logger.info(kilometer + " kilometer = " + mile + " mile");
        return mile;
	}

}
