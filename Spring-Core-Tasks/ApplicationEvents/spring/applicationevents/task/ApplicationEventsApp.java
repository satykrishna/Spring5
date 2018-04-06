package spring.applicationevents.task;

import org.Spring.Core.Scope.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.applicationevents.publisher.MessagePublisher;

public class ApplicationEventsApp {


	public static void main(String[] args) {
		
		ApplicationContext appContext = 
				new AnnotationConfigApplicationContext("spring.applicationevents.configuration");
		
		ShoppingCart shoppingCart = appContext.getBean(ShoppingCart.class);
		
		MessagePublisher publisher = appContext.getBean(MessagePublisher.class);
		
		publisher.publish(shoppingCart);
		
		((AnnotationConfigApplicationContext)appContext).close();
		
	}
}
