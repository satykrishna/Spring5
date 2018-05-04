package example.spring.mvc.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import example.spring.mvc.interceptor.MeasurementInterceptor;

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
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(measurementInterceptor()); - applies to all path patterns
		registry.addInterceptor(measurementInterceptor())
				.addPathPatterns("/member"); // apply to only path /member
	}
	
	@Bean
	public MeasurementInterceptor measurementInterceptor() {
		return new MeasurementInterceptor();
	}
	
	//http://localhost:8080/court/welcome?language=en_US
	//http://localhost:8080/court/welcome?language=de
	//can change locale on fly with variable language
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = 
				new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		return localeChangeInterceptor;
	}
	
	//Cookie Based locale resolver. -- good one to use. 
	//There are others such as session based locale resolver. Look for page number 137
	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setCookieName("language");
		cookieLocaleResolver.setCookieMaxAge(3600);
		cookieLocaleResolver.setDefaultLocale(new Locale("en"));
		return cookieLocaleResolver;
	}

	//Externalize localization
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = 
				new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	
}
