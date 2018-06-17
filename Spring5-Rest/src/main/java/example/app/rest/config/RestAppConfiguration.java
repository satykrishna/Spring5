package example.app.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import example.app.rest.model.Member;
import example.app.rest.model.Members;

@Configuration
@ComponentScan(basePackages = "example.app.rest")
public class RestAppConfiguration {

	@Bean
	public View memberTemplate() {
		return new MarshallingView(jaxb2Marshaller());
	}

	@Bean
	public Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Members.class, Member.class);
		return marshaller;
	}

	@Bean
	public ViewResolver viewResolver() {
		return new BeanNameViewResolver();
	}

}
