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
			value="execution(spring.aspect..*CalculatorImpl)",
			defaultImpl=CounterImpl.class
			)
	public Counter counter;
	
	
	@Pointcut("execution(* spring.aspect..*CalculatorImpl.*(..))")
	public void executeCalculatorMethods(){
		
	}
	
	@After("executeCalculatorMethods() && this(counter)")
	public void increaseCounter(Counter counter){
		counter.increase();
	}
}
