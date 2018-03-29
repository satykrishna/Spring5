package spring.aspect.example;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
//@Order(0)
public class CalculatorValidationAspect {


	@Before("spring.aspect.example.PointCutDefinitionsForCalculator.loggingOperationPointCut()")
	public void validateBefore(JoinPoint joinPoint) throws IllegalArgumentException {
		Arrays.stream(joinPoint.getArgs()).forEach(this::validate);
	}
	
	
	private  void validate(Object val) {
		double value = (double) val;
		if(value < 0) throw new IllegalArgumentException("Illegal Argument " + value);
 	}
	
	
}
