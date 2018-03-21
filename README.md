##SPRING 5

This project deals with Spring 5

###SPRING CORE
*   @Configuration
*   @Bean
*	AnnotationConfigApplicationContext

*	@Component, @Repository, @Service, @Controller
*	@ComponentScan - Scan @Component annotations within specified packages mentioned.
     
	@ComponentScan(basePackages = { "org.Spring.Core.*" }, includeFilters = {
		@ComponentScan.Filter(type = FilterType.REGEX, pattern = { "org.Spring.Core.dao.*" }) })
	
