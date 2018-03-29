package spring.aspect.introductions.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import spring.aspect.introductions.service.Counter;

public class CounterImpl implements Counter {

	private AtomicInteger count = new AtomicInteger(0);
	
	@Override
	public void increase() {
		count.getAndIncrement();
	}

	@Override
	public int getCount() {
		return count.get();
	}

}
