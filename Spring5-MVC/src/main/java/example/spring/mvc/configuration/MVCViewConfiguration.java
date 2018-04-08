package example.spring.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="example.spring.mvc.controller")
@Import(value=CourtConfiguration.class)
public class MVCViewConfiguration {

	@Bean
	public InternalResourceViewResolver internalViewResolver() {
		
		InternalResourceViewResolver viewResolver = 
				new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
		
		return viewResolver;
	}
	
}
