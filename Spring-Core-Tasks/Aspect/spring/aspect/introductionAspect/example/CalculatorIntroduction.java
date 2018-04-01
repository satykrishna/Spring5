package spring.aspect.introductionAspect.example;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import spring.aspect.introductions.service.Counter;
import spring.aspect.introductions.service.MaxCalculator;
import spring.aspect.introductions.service.MinCalculator;
import spring.aspect.introductions.service.impl.CounterImpl;
import spring.aspect.introductions.service.impl.MaxCalculatorImpl;
import spring.aspect.introductions.service.impl.MinCalculatorImpl;

@Aspect
@Component
@Order(-1)
public class CalculatorIntroduction {

	@DeclareParents(
			value="spring.aspect.service.impl.ArithmeticCalculatorImpl",
			defaultImpl=MaxCalculatorImpl.class)
	public MaxCalculator maxCalculator;
	
	@DeclareParents(
			value="spring.aspect.service.impl.ArithmeticCalculatorImpl",
			defaultImpl=MinCalculatorImpl.class)
	public MinCalculator minCalculator;
	
	
	@DeclareParents(
//			value="spring.aspect..*CalculatorImpl ",
			value="spring.aspect.service.impl.*CalculatorImpl ",
			defaultImpl=CounterImpl.class)//includes classes in multiple packages
	public Counter counter;
	
	@Pointcut("execution(* spring.aspect..*Calculator.*(..))")
	public void arthimeticUnitMaxMinCalculator(){
		
	}
	
	@After("arthimeticUnitMaxMinCalculator()"
			+ "&& this(counter)"
			)
	public void incrementCounter(Counter counter) {
		counter.increase();
	}
	
	
}
