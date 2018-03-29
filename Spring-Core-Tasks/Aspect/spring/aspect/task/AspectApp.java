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
		
//		Counter addCounter = (Counter)calculator;
		
//		System.out.println("\n SATYA " + addCounter.getCount());
		
		MaxCalculator maxCalculator = (MaxCalculator)calculator;
		
		MinCalculator minCalculator = (MinCalculator) calculator;
		
		maxCalculator.max(3.4, 4.31);
		
		Counter maxCounter = (Counter)maxCalculator;
		
		System.out.println("\nCount " +maxCounter.getCount());
		
		minCalculator.min(11, 1.1);
		
		Counter minCounter = (Counter)minCalculator;
		
		System.out.println("\nCount " +minCounter.getCount());
		
		
		UnitCalculator unitCalculator = 
				appContext.getBean(UnitCalculator.class);
		unitCalculator.kilogramToPound(75);
		unitCalculator.kilometerToMile(5);
		
		Counter unitCounter = (Counter)unitCalculator;
		
		System.out.println("\nCount " +unitCounter.getCount());
		
	}
	
	
	public static void main(String[] args) {
		calculatorAspect();
		System.out.println("--------------");
		calculatorIntroductionAspect();
	}
}
