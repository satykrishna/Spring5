package example.app.rest.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@ComponentScan(basePackages = "example.app.rest")
public class RestAppConfiguration {

	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter adapter = 
				new RequestMappingHandlerAdapter();
		adapter.setMessageConverters(Arrays.asList(jsonMessageConverter(), xmlMessageConverter()));
		return adapter;
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter jsonMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}
	
	@Bean
	public Jaxb2RootElementHttpMessageConverter xmlMessageConverter() {
		return new Jaxb2RootElementHttpMessageConverter();
	}


}
