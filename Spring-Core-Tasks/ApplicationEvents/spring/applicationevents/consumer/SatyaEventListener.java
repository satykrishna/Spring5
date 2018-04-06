package spring.applicationevents.consumer;

import static org.Spring.java8.util.AppLogger.log;
import static org.apache.log4j.Level.INFO;

import org.apache.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import spring.applicationevents.example.SatyaEvent;

@Component
public class SatyaEventListener {

	private static final Logger logger = 
			Logger.getLogger(SatyaEventListener.class);

	@EventListener
	public void onCheckOutEvent(SatyaEvent event) {
		log(logger, INFO, ()->event.toString());
	}

}
