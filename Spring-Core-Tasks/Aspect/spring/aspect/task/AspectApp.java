package spring.aspect.task;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.aspect.service.ArithmeticCalculator;
import spring.aspect.service.UnitCalculator;

public class AspectApp {

	private static final Logger logger = 
			Logger.getLogger(AspectApp.class);
	
	private static ApplicationContext appContext;
	
	public static void calculatorAspect() {
		
		appContext = new AnnotationConfigApplicationContext("spring.aspect.configuration");
		
		ArithmeticCalculator calculator = 
				appContext.getBean(ArithmeticCalculator.class);
		
		calculator.add(1, 2);
		
		calculator.mul(2, 4);
		
		calculator.div(1, 9);
		
		calculator.sub(10, 9);
		
		UnitCalculator unitCalculator = 
				appContext.getBean(UnitCalculator.class);
		
		unitCalculator.kilogramToPound(75);
		
		unitCalculator.kilometerToMile(5);
		
	}
	
	public static void main(String[] args) {
		
		calculatorAspect();
	}
}
