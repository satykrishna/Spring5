package example.spring.mvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import example.spring.mvc.convertor.SportTypeConverter;
import example.spring.mvc.service.ReservationService;

@Configuration
public class CustomFormatter implements WebMvcConfigurer {

	@Autowired
	private ReservationService reservationService;
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter((Formatter<?>) new SportTypeConverter(reservationService));
	}
}
