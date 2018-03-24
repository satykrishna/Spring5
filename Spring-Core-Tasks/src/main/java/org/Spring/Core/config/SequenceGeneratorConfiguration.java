package org.Spring.Core.config;

import org.Spring.Core.Service.PrefixGenerator;
import org.Spring.model.SequenceGenerator;
import org.junit.validator.ValidateWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@Import(PrefixConfiguration.class)
public class SequenceGeneratorConfiguration {

	@Value("#{datePrefixGenerator}")
	private PrefixGenerator prefixGenerator;
	
	@Bean
	@Primary
	public SequenceGenerator sequenceGenerator() {
		SequenceGenerator sequenceGenerator = new SequenceGenerator();
		sequenceGenerator.setPrefix("30");
		sequenceGenerator.setSuffix("A");
		sequenceGenerator.setInitial(100000);
		return sequenceGenerator;
	}
	
/*	@Bean
	public SequenceGenerator sequenceGeneratorWithPrefix() {
		SequenceGenerator gen = new SequenceGenerator();
		gen.setInitial(1000);
		gen.setSuffix("A");
		gen.setPrefixGenerator(prefixGenerator);
		return gen;
	}*/
	
	
	
}
