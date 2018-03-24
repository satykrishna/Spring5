package org.Spring.Core.Service.impl;

import org.Spring.Core.Service.SequenceService;
import org.Spring.Core.dao.SequenceDAO;
import org.Spring.model.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sequenceService")
public class SequenceServiceImpl implements SequenceService {

	@Autowired
	@Qualifier("sequenceDAO")
	private SequenceDAO sequenceDAO;
	
	
	@Override
	public String generate(String sequenceId) {
		Sequence sequence = sequenceDAO.getSequence(sequenceId);
		int value = sequenceDAO.getNextValue(sequenceId);
		return sequence.getPrefix() + value + sequence.getSuffix();
	}

}
