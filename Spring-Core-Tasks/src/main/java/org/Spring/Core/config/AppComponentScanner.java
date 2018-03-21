package org.Spring.Core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
	basePackages={"org.Spring.Core.*"},
	includeFilters = { @ComponentScan.Filter(type = FilterType.REGEX, pattern = { "org.Spring.Core.dao.*" }) }
)
@Configuration
public class AppComponentScanner {

}
