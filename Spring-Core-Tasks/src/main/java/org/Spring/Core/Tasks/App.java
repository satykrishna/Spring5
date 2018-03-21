package org.Spring.Core.Tasks;

import org.Spring.Core.config.SequenceGeneratorConfiguration;
import org.Spring.Core.dao.SequenceDAO;
import org.Spring.model.Product;
import org.Spring.model.SequenceGenerator;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */

public class App {

	private static final Logger logger = Logger.getLogger(App.class);

	private static ApplicationContext appContext;

	@SuppressWarnings("unused")
	private static void UsingBeanAnnotationAndConfigurationAnnotation() {
		appContext = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);
		SequenceGenerator sequenceGen = appContext.getBean("sequenceGenerator", SequenceGenerator.class);
		logger.info(sequenceGen.getSequence());
		logger.info(sequenceGen.getSequence());

	}

	public static void main(String[] args) {

		appContext = new AnnotationConfigApplicationContext("org.Spring.Core.config");
		SequenceDAO sequenceDAO = (SequenceDAO) appContext.getBean("sequenceDAO");
		Product aaa = appContext.getBean("aaa", Product.class);
		Product cdrw = appContext.getBean("cdrw", Product.class);
		logger.info("Product aaa " + aaa);
		logger.info("Product cdrw " + cdrw);
		

	}
}
