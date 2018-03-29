package spring.aspect.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCutDefinitionsForCalculator {

	@Pointcut("execution(* *.*(..))")
	public void loggingOperationPointCut() {
	}
	
	@Pointcut("@annotation(spring.aspect.example.LoggingRequired)")
	public void loggingOperationintCutForElementsAnnotatedWithAnnotation_LoggingRequired() {
		
	}

	@Pointcut("within(spring.aspect.service.impl.*)")
	public void withInPointCutForServicePackage(){
		
	}
	
	@Pointcut("within(spring.aspect.service.impl.ArithmeticCalculatorImpl)")
	public void withInPointCutForArithmeticCalculatorImpl() {
		
	}
	
	@Pointcut("within(spring.aspect.service.ArithmeticCalculator+)")
	public void withInPointCutForImplementationClassofArithmeticCalculatorInterface(){
		
	}
	
	@Pointcut("withInPointCutForImplementationClassofArithmeticCalculatorInterface() ||"
			+ "withInPointCutForServicePackage()")
	public void combiningTwoOrMorePointCuts() {
		
	}
	
	
	@Pointcut("loggingOperationPointCut() && target(targetClass) && args(arg1, arg2)")
	public void accessParametersOfJoinPointAndReturnValueThroughThisPointrCut(
			Object targetClass, double arg1, double arg2) {
		
	}
}
