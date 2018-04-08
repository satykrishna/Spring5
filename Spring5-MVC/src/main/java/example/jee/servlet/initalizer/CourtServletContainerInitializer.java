package example.jee.servlet.initalizer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import example.spring.mvc.configuration.MVCViewConfiguration;

public class CourtServletContainerInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(MVCViewConfiguration.class); // we can specify many
		DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
		ServletRegistration.Dynamic courtRegistration = ctx.addServlet("court", dispatcherServlet);
		courtRegistration.setLoadOnStartup(1);
		courtRegistration.addMapping("/");
	}

}
