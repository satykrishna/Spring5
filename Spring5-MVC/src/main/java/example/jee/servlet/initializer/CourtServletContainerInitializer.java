package example.jee.servlet.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import example.spring.mvc.config.CourtConfiguration;
import example.spring.mvc.configuration.MVCViewConfiguration;

public class CourtServletContainerInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();

		appContext.register(CourtConfiguration.class);

		DispatcherServlet servlet = new DispatcherServlet(appContext);

		ServletRegistration.Dynamic courtRegistration = ctx.addServlet("court", servlet);

		courtRegistration.setLoadOnStartup(1);
		
		courtRegistration.addMapping("/");
	}

}
