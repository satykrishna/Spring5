package org.Spring.Core.Tasks;

import java.io.IOException;
import java.util.Properties;

import org.Spring.Core.Scope.ShoppingCart;
import org.Spring.Core.config.ShopConfiguration;
import org.Spring.Core.dao.SequenceDAO;
import org.Spring.model.Product;
import org.Spring.model.SequenceGenerator;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * Hello world!
 *
 */
@SuppressWarnings("unused")
public class App {

	private static final Logger logger = Logger.getLogger(App.class);

	private static ApplicationContext appContext;

	private static void UsingBeanAnnotationAndConfigurationAnnotation() {
		SequenceGenerator sequenceGen = appContext.getBean("sequenceGenerator", SequenceGenerator.class);
		logger.info(sequenceGen.getSequence());
		logger.info(sequenceGen.getSequence());

	}
	
	private static void testScopesofTheBean() {
		appContext = new AnnotationConfigApplicationContext(ShopConfiguration.class);
		Product aaa = appContext.getBean("aaa", Product.class);
		Product cdrw = appContext.getBean("cdrw", Product.class);
		Product dvdrw = appContext.getBean("dvdrw", Product.class);
		ShoppingCart cart1 = appContext.getBean("shoppingCart", ShoppingCart.class);
		cart1.addItem(aaa);
		cart1.addItem(cdrw);
		logger.info("cart1 " + cart1.getItems());
		ShoppingCart cart2 = appContext.getBean("shoppingCart", ShoppingCart.class);
		cart2.addItem(dvdrw);
		System.out.println("Cart2 " + cart2.getItems());
	}
	
	private static void appContextWithPackageAsParamsToAnnotationConigApplicationContext() {
		appContext = new AnnotationConfigApplicationContext("org.Spring.Core.config");
		UsingBeanAnnotationAndConfigurationAnnotation();
		SequenceDAO sequenceDAO = (SequenceDAO) appContext.getBean("sequenceDAO");
		Product aaa = appContext.getBean("aaa", Product.class);
		Product cdrw = appContext.getBean("cdrw", Product.class);
		logger.info("Product aaa " + aaa);
		logger.info("Product cdrw " + cdrw);
		logger.info(sequenceDAO.getNextValue("IT"));
		logger.info(sequenceDAO.getNextValue("IT"));

	}
	
	private static void testBannerLoader() {
		appContext = new AnnotationConfigApplicationContext(ShopConfiguration.class);
//		BannerLoader bannerLoader = appContext.getBean(BannerLoader.class);
	}

	private static void readFileExplictlyUsingSpringIOC() throws IOException {
		Resource resource = new ClassPathResource("discounts.properties");
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);
		logger.info(properties);
	}
	
	public static void main(String[] args) throws IOException {
		testBannerLoader();
		readFileExplictlyUsingSpringIOC();
	}
}
