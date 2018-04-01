package spring.aspect.introductions.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import static org.Spring.java8.util.AppLogger.*;
import static  org.apache.log4j.Level.*;
import org.apache.log4j.Logger;

import spring.aspect.introductions.service.Counter;

public class CounterImpl implements Counter {
	
	private static Logger logger = Logger.getLogger(CounterImpl.class);

	private  AtomicInteger count = new AtomicInteger(0);
	
	@Override
	public void increase() {
		log(logger, INFO, ()-> "Increase function : " + count);
		count.getAndIncrement();
	}

	@Override
	public int getCount() {
		return count.get();
	}

}
