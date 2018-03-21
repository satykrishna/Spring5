package org.Spring.Core.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.Spring.Core.dao.SequenceDAO;
import org.Spring.model.Sequence;
import org.springframework.stereotype.Component;

@Component("sequenceDAO")
public class SequenceDAOImpl implements SequenceDAO {
	
	private static final Logger logger = Logger.getLogger(SequenceDAOImpl.class.getName());

	private final Map<String, Sequence> sequences = 
			new HashMap<String, Sequence>();
	
	private final Map<String, AtomicInteger> values = 
			new HashMap<String, AtomicInteger>();
	
	@Override
	public Sequence getSequence(String sequenceId) {
		return sequences.get(sequenceId);
	}

	@Override
	public int getNextValue(String sequenceId) {
		AtomicInteger value = values.get(sequenceId);
		return value.getAndIncrement();
	}

	@PostConstruct
	public void initialize() {
		sequences.put("IT", new Sequence("IT", "30", "A"));
		values.put("IT", new AtomicInteger(10000));
	}
	
}
