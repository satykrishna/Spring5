package com.example.security.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.codec.CodecConfigurer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
public class TodoSecurityConfiguration extends AbstractSecurityWebApplicationInitializer {

	public TodoSecurityConfiguration() {
		super(TodoSecurityConfig.class);
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("satya").password("pass").authorities("USER").and().withUser("krish").password("pass").authorities("USER",
				"ADMIN");
	}

	protected void configure(HttpSecurity http) throws Exception {

	}

}
