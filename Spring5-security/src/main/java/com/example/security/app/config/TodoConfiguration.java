package com.example.security.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {
		"com.example.security.service.*",
		"com.example.security.dao.*"
})
public class TodoConfiguration {

}
