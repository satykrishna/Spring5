package org.Spring.Core.postProcessor;

import org.Spring.model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class AuditCheckBeanPostProcessor implements BeanPostProcessor {

	private static final Logger logger = Logger.getLogger(AuditCheckBeanPostProcessor.class);

	public AuditCheckBeanPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		if(bean instanceof Product) {
			String productName = ((Product)bean).getName();
			logger.info("In ProductCheckBeanPostProcessor. ProcessBeforeInitialization, processing Product: " + productName);
		}
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof Product) {
			String productName = ((Product)bean).getName();
			logger.info("In ProductCheckBeanPostProcessor. ProcessBeforeInitialization, processing Product: " + productName);
		}
		
		return bean;
	}
}
