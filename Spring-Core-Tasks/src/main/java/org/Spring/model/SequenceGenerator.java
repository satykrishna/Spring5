package org.Spring.model;

import java.util.concurrent.atomic.AtomicInteger;

import org.Spring.Core.Service.PrefixGenerator;
import org.springframework.beans.factory.annotation.Autowired;

public class SequenceGenerator {

	private String prefix;
	private String suffix;
	private int initial;
	private final AtomicInteger counter = new AtomicInteger();
	
	@Autowired
	private PrefixGenerator prefixGenerator;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public int getInitial() {
		return initial;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	public AtomicInteger getCounter() {
		return counter;
	}

	public SequenceGenerator() {
		super();
	}

	public String getSequence() {
		StringBuilder builder = new StringBuilder();
		builder.append(prefix).append(initial).append(counter.getAndIncrement()).append(suffix);
		return builder.toString();
	}
	
	@Override
	public String toString() {
		return getSequence();
	}

	public PrefixGenerator getPrefixGenerator() {
		return prefixGenerator;
	}

	public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}
}
