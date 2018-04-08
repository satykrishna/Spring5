package example.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import example.spring.mvc.configuration.MVCViewConfiguration;


@Configuration
@ComponentScan(basePackages="example.spring.mvc.service.impl")
@Import(MVCViewConfiguration.class)
public class CourtConfiguration {

}
