package example.spring.mvc.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

public class ContentViewResolverConfiguration implements WebMvcConfigurer {

	@Autowired
	private ContentNegotiationManager contentNegotiationManager;
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		Map<String, MediaType> mediatypes = new HashMap<String, MediaType>();
		mediatypes.put("html", MediaType.TEXT_HTML);
		mediatypes.put("pdf", MediaType.valueOf("application/pdf"));
		mediatypes.put("xls", MediaType.valueOf("application/vnd.ms-excel"));
		mediatypes.put("xml", MediaType.APPLICATION_XML);
		mediatypes.put("json", MediaType.APPLICATION_JSON);
		configurer.mediaTypes(mediatypes);
	}
	
	
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		ContentNegotiatingViewResolver viewResolver = 
				new ContentNegotiatingViewResolver();
		viewResolver.setContentNegotiationManager(contentNegotiationManager);
		return viewResolver;
	}
}
