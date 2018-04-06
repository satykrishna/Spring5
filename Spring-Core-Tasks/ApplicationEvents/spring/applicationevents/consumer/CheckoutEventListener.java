package spring.applicationevents.consumer;

import static org.Spring.java8.util.AppLogger.*;

import static org.apache.log4j.Level.*;
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
		log(logger, INFO, ()->event.toString());
	}
	
}
