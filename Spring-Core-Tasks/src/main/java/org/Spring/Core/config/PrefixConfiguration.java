package org.Spring.Core.config;

import org.Spring.Core.Service.PrefixGenerator;
import org.Spring.Core.Service.impl.DatePrefixGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrefixConfiguration {
	
	@Bean
	public PrefixGenerator datePrefixGenerator() {
		return new DatePrefixGenerator();
	}

}
