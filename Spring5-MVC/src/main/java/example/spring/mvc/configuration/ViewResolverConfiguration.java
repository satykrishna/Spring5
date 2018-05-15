package example.spring.mvc.configuration;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.XmlViewResolver;

@Configuration
public class ViewResolverConfiguration implements WebMvcConfigurer, ResourceLoaderAware {

	private ResourceLoader resourceLoader;
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	//resolve from XML File
	@Bean
	public ViewResolver viewResolver() {
		XmlViewResolver viewResolver = new XmlViewResolver();
        viewResolver.setLocation(resourceLoader.getResource("/WEB-INF/xmlviews/court-views.xml"));
        viewResolver.setOrder(2);
        return viewResolver;
	}
}
