package com.example.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.security.dao.TodoDao;
import com.example.security.model.Todo;
import com.example.security.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoDao todoDao;

	@Override
	public List<Todo> findAll() {
		return todoDao.findAll();
	}

	@Override
	public Optional<Todo> findById(long id) {
		return todoDao.findById(id);
	}

	@Override
	public void remove(long id) {
		todoDao.remove(id);
	}

	@Override
	public Todo save(Todo todo) {
		return todoDao.save(todo);
	}

	@Override
	public List<Todo> findByOwner(String author) {
		return todoDao.findByOwner(author);
	}

	@Override
	public void complete(long id) {
		findById(id).ifPresent(todo -> {
			todo.setCompleted(true);
			todoDao.save(todo);
		});
	}
}
