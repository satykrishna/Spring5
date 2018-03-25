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
	
*	@Autowired - Find the Bean of a given type

*	@Qualifier
*   @Primary

* 	@Import - Used for importing configuration from other @Configuration class

*	@Resource 
*	@Inject 

Autowired, Resource, Inject, all three annotations does autowiring by type. However
to resolve ambiguity

  Autowired annotation requires Qualifier annotation
  Resource annotation doesn't require anything, it will resolve the ambiquity by the bean name
  Inject annotation require a custom annotation to be defined
  
  
  PropertySourcesPlaceholderConfigurer is used to read properties from a file
  @PropertySource is used to to mention the filename
  
  Spring's Resource class is used to read the external file and this can be used to 
  create the InputStream.
  
   ReloadableResourceBundleMessageSource is used for I18N.
   
   @Required - To check if the property of a Bean is set
   
   @Scope (Prototype, singleton-default, request, request, globalSession, session)
   
   @Lazy, @DependsOn
   
   CUSTOMBeanPostProcessor is used for all Beans