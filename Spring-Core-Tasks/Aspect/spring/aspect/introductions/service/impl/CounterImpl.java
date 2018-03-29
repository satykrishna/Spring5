package spring.aspect.introductions.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import static  org.apache.log4j.Level.*;
import org.apache.log4j.Logger;
import static org.spring.java8.util.AppLogger.*;

import spring.aspect.introductions.service.Counter;

public class CounterImpl implements Counter {
	
	private static Logger logger = Logger.getLogger(CounterImpl.class);

	private static AtomicInteger count = new AtomicInteger(0);
	
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
