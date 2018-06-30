package example.app.rest.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import example.app.rest.config.RestAppConfiguration;

public class RestAppServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{RestAppConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/rest/*"};
	}

}
