package spring.aspect.example;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component("calculatorLoggingAspect")
@Order(1)
public class CalculatorLoggingAspect {

	private static Logger logger = 
			Logger.getLogger(CalculatorLoggingAspect.class);
	
	@Before("spring.aspect.example.PointCutDefinitionsForCalculator.loggingOperation()")
	public void logBefore(JoinPoint jointPoint) {
		logger.info("The method " + jointPoint.getSignature().getName() 
		 + "() begins with " + Arrays.toString(jointPoint.getArgs()));
	}
	
	@After("spring.aspect.example.PointCutDefinitionsForCalculator.loggingOperation()")
	public void logAfter(JoinPoint jointPoint) {
		logger.info("The method " + jointPoint.getSignature().getName() 
		 + "() begins with " + Arrays.toString(jointPoint.getArgs()));
	}
	
	@AfterReturning(
			pointcut="spring.aspect.example.PointCutDefinitionsForCalculator.loggingOperation()",
			returning="result"
			)
	public void logAfterReturning(JoinPoint jointPoint, Object result) {
		logger.info("The method " + jointPoint.getSignature().getName() 
				 + "() ends with " + result);	
	}
	
	@AfterThrowing(
			pointcut = "spring.aspect.example.PointCutDefinitionsForCalculator.loggingOperation()",
			throwing="e"
			)
	public void logAfterThrowingException(JoinPoint jp, Throwable e) {
		logger.info("The method " + jp.getSignature().getName() 
				 + "() throws exception " + e);	
	}
	
	@AfterThrowing(
		 pointcut = "spring.aspect.example.PointCutDefinitionsForCalculator.loggingOperation()",
		 throwing = "e"
			)
	public void logAfterThrowingSpecificException(JoinPoint jp, IllegalArgumentException e) {
		logger.info("The method " + jp.getSignature().getName() 
				 + "() with arguments " +jp.getArgs() +" throws Illegal Argument Exception " + e);
	}
	
	
	@Around("spring.aspect.example.PointCutDefinitionsForCalculator.loggingOperation()")
	public Object logAround(ProceedingJoinPoint jointPoint) throws Throwable {
		logger.info("The method " + jointPoint.getSignature().getName() 
				 + "() begins with " + Arrays.toString(jointPoint.getArgs()));
		
		try{
			Object result =jointPoint.proceed();
			logger.info("The method " + jointPoint.getSignature().getName() 
					 + "() ends with " + result);	
			return result;
		}
		catch(IllegalArgumentException e) {
			logger.info("The method " + jointPoint.getSignature().getName() 
					 + "() with arguments " +jointPoint.getArgs() +" throws Illegal Argument Exception " + e);
			throw e;
		}
	}
	
	
	@Before("spring.aspect.example.PointCutDefinitionsForCalculator.loggingOperation()")
	public void logBeforeForJointPoint(JoinPoint joinPoint) {
		logger.info("Joint point is of Kind: " + joinPoint.getKind()
		+" \nSignature declaring type: " + joinPoint.getSignature().getDeclaringType() + 
		" \nSignature name: "+joinPoint.getSignature().getName()
		+"\n Arguments: "+Arrays.toString(joinPoint.getArgs())
		+"\n Target class : "+joinPoint.getTarget().getClass().getName()
		+"\n This class : "+joinPoint.getThis().getClass().getName());
	}
}
