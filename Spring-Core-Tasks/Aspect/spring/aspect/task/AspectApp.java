package spring.aspect.task;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.aspect.introductions.service.Counter;
import spring.aspect.introductions.service.MaxCalculator;
import spring.aspect.introductions.service.MinCalculator;
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
	
	public static void calculatorIntroductionAspect() {
		appContext = new AnnotationConfigApplicationContext("spring.aspect.configuration");
		ArithmeticCalculator calculator = 
				appContext.getBean(ArithmeticCalculator.class);
		calculator.add(4, 5);
		MaxCalculator maxCalculator = (MaxCalculator)calculator;
		MinCalculator minCalculator = (MinCalculator) calculator;
		maxCalculator.max(3.4, 4.31);
		minCalculator.min(11, 1.1);
		UnitCalculator unitCalculator = 
				appContext.getBean(UnitCalculator.class);
		unitCalculator.kilogramToPound(75);
		unitCalculator.kilometerToMile(5);
	}
	
	
	public static void countNoofCalculatorObjectsUsingIntroductionsInAspect() {
		appContext = new AnnotationConfigApplicationContext("spring.aspect.configuration");
		ArithmeticCalculator calculator = 
				appContext.getBean(ArithmeticCalculator.class);
		
		calculator.add(4, 5);
		
		Counter counter = (Counter)calculator;
		
		System.out.println("The count is " + counter.getCount());
		
		calculator.mul(4, 5);
		
		System.out.println("The count is " + counter.getCount());
		
		UnitCalculator unitCalculator = 
				appContext.getBean(UnitCalculator.class);
		
		unitCalculator.kilogramToPound(75);
		
		System.out.println("The count is " + counter.getCount());

		unitCalculator.kilometerToMile(5);

		System.out.println("The count is " + counter.getCount());

		MaxCalculator maxCalculator = (MaxCalculator)calculator;
		
		maxCalculator.max(2, 1);
		
		Counter c = (Counter)maxCalculator;
		
		System.out.println("The count is " + c.getCount());

		
	}
	
	public static void main(String[] args) {
//		calculatorAspect();
		System.out.println("--------------");
//		calculatorIntroductionAspect();
		countNoofCalculatorObjectsUsingIntroductionsInAspect();
	}

	
}
