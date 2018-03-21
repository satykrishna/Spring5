package org.Spring.Core.dao;

import org.Spring.model.Sequence;

public interface SequenceDAO {

	public Sequence getSequence(String sequenceId);
	public int getNextValue(String sequenceId);
	
}
