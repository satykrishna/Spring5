package example.spring.mvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "example.spring.mvc.service.impl")
public class CourtConfiguration{
	
}
