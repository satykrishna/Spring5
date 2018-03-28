package spring.aspect.example;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("calculatorLoggingAspect")
public class CalculatorLoggingAspect {

	private static Logger logger = 
			Logger.getLogger(CalculatorLoggingAspect.class);
	

	@Before("execution(* spring.aspect.service.ArithmeticCalculator.add(..))")
	public void logBefore() {
		logger.info("The method add() begins");
	}
	
	
}
