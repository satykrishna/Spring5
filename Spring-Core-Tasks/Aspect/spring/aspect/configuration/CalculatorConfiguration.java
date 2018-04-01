package spring.aspect.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"spring.aspect.service.impl", 
							 "spring.aspect.example",
							 "spring.aspect.introductionAspect.example"})
@EnableLoadTimeWeaving
public class CalculatorConfiguration {


}
