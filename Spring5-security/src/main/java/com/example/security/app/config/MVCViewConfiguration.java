package com.example.security.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.example.security.model.Todo;

@Configuration
@ComponentScan(basePackages = { "com.example.security.controller", "com.example.security.validator" })

@Import(value = { TodoSecurityConfiguration.class, TodoConfiguration.class })
public class MVCViewConfiguration implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver internalViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/jsp/", ".jsp");
		viewResolver.setOrder(0);
		return viewResolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:/todos");
	}
}
