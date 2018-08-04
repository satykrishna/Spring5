package com.example.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.security.model.Todo;
import com.example.security.service.TodoService;
import com.example.security.validator.TodoValidator;

@Controller
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@Autowired
	private TodoValidator todoValidator;

	@GetMapping
	public String listofTodos(Model model) {
		model.addAttribute("todos", todoService.findAll());
		return "todos";
	}

	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("todo", new Todo());
		return "todo-create";
	}

	@PostMapping
	public String newMessage(@ModelAttribute @Validated Todo todo, BindingResult errors) {

		if (errors.hasErrors()) {
			return "todo-create";
		}
		String owner = "marten@apressmedia.net";
		todo.setOwner(owner);
		todoService.save(todo);
		return "redirect:/todos";
	}

	@PutMapping("/{todoId}/completed")
	public String complete(@PathVariable("todoId") long todoId) {
		this.todoService.complete(todoId);
		return "redirect:/todos";
	}

	@DeleteMapping("/{todoId}")
	public String delete(@PathVariable("todoId") long todoId) {
		this.todoService.remove(todoId);
		return "redirect:/todos";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(todoValidator);
        binder.setDisallowedFields("id", "owner");
	}
}
