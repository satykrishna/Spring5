package example.spring.mvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages="example.spring.mvc.service.impl")
@Import(MVCViewConfiguration.class)
public class CourtConfiguration{
	
}
