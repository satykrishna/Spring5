package com.example.security.service;

import java.util.List;
import java.util.Optional;

import com.example.security.model.Todo;

public interface TodoService {

	public abstract List<Todo> findAll();

	public abstract Optional<Todo> findById(long id);

	public abstract void remove(long id);

	public abstract Todo save(Todo todo);

	public abstract List<Todo> findByOwner(String author);
	
    public abstract void complete(long id);

}
