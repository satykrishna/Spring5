package com.example.security.validator;

import static org.apache.commons.lang3.StringUtils.isAllBlank;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.security.model.Todo;


@Component
public class TodoValidator implements Validator{

	@Override
	public boolean supports(Class<?> cls) {
		return Todo.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errs) {
		
		Todo todo = (Todo) target;
		
		if(isAllBlank(todo.getDescription())) {
			errs.reject("invalid.description", "invalid description");
		}
		
		
	}

}
