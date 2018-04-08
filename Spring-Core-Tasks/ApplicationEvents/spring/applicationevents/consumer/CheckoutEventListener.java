package spring.applicationevents.consumer;

import static org.Spring.java8.util.AppLogger.log;
import static org.apache.log4j.Level.INFO;

import java.util.List;

import org.Spring.model.Product;
import org.apache.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import spring.applicationevents.example.CheckoutEvent;

@Component
public class CheckoutEventListener {
	
	private static final Logger logger = 
			Logger.getLogger(CheckoutEventListener.class);

	@EventListener
	public void onCheckOutEvent(CheckoutEvent event) { 
		
		List<Product> products = event.getCart().getItems();
		
		products.stream().filter(p->p.getPrice() <= 1)
						 .forEach(p->log(logger, INFO, ()->p.toString()));
	
		
	}
	
}
