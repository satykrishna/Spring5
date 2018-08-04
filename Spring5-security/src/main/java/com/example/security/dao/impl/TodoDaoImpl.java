package com.example.security.dao.impl;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.example.security.dao.TodoDao;
import com.example.security.model.Todo;

@Repository
public class TodoDaoImpl implements TodoDao {

	private List<Todo> todoList = new ArrayList<>();

	@Override
	public List<Todo> findAll() {
		return todoList;
	}

	@Override
	public Optional<Todo> findById(long id) {
		return todoList.stream().filter(todo -> todo.getId() == id).findAny();
	}

	@Override
	public void remove(long id) {
		todoList = todoList.stream().filter(todo -> todo.getId() != id).collect(toList());
	}

	@Override
	public Todo save(Todo todo) {
		Optional<Todo> optionalTodo = todoList.stream().filter(t -> t.getId() == todo.getId()).findAny();

		if (!optionalTodo.isPresent()) {
			todoList.stream().filter(t -> t.getId() == todo.getId()).findAny().ifPresent(t -> {
				t.setCompleted(todo.isCompleted());
				t.setDescription(todo.getDescription());
				t.setOwner(todo.getOwner());
				t.setId(todo.getId());
			});
		}
		
		else {
			todoList.add(todo);
		}

		return todo;
	}

	@Override
	public List<Todo> findByOwner(String author) {
		return todoList.stream().filter(todo -> StringUtils.equalsIgnoreCase(todo.getOwner(), author)).collect(toList());
	}

	@PostConstruct
	private void initializeDataFromList() {
		Todo todo = new Todo();
		todo.setOwner("marten@apressmedia.net");
		todo.setDescription("Finish Spring Recipes - Security Chapter");
		todoList.add(todo);

		todo = new Todo();
		todo.setOwner("marten@apressmedia.net");
		todo.setDescription("Get Milk & Eggs");
		todo.setCompleted(true);
		todoList.add(todo);

		todo = new Todo();
		todo.setOwner("marten@apressmedia.net");
		todo.setDescription("Call parents.");
		todoList.add(todo);
	}
}
