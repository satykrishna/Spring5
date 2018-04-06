package spring.applicationevents.publisher;

import java.util.Date;

import org.Spring.Core.Scope.ShoppingCart;
import org.Spring.Core.Service.PrefixGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import spring.applicationevents.example.CheckoutEvent;
import spring.applicationevents.example.SatyaEvent;

@Component
public class MessagePublisher {
	
	 @Autowired
	 private ApplicationEventPublisher applicationEventPublisher;
	 
	 private static int counter  = 0;

	public void publish(ShoppingCart shoppingCart) {
		CheckoutEvent event = new CheckoutEvent(shoppingCart, new Date());
		SatyaEvent satyaEvent = new SatyaEvent("message", ++counter);
		applicationEventPublisher.publishEvent(event);
		applicationEventPublisher.publishEvent(satyaEvent);
	}

}
