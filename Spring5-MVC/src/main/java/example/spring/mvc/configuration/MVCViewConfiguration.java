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
public class MVCViewConfiguration  implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver internalViewResolver() {
		InternalResourceViewResolver viewResolver = 
				new InternalResourceViewResolver("/jsp/", ".jsp");
		return viewResolver;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("welcome");
	}
	
}
