package org.Spring.Core.config;

import java.util.HashMap;
import java.util.Map;

import org.Spring.Core.Factory.DiscountFactoryBean;
import org.Spring.Core.Factory.ProductCreator;
import org.Spring.Core.Service.impl.BannerLoader;
import org.Spring.model.Battery;
import org.Spring.model.Disc;
import org.Spring.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("org.Spring.Core.Scope, org.Spring.Core.i18N, org.Spring.Core.PostProcessor")
@PropertySource("classpath:discounts.properties")
public class ShopConfiguration {


	@Value("${endofyear.discount:0}")
	private double specialEndOfYearDiscountField;
	
	@Value("classpath:banner.txt")
	private Resource resource;
	
	public ShopConfiguration() {
	}

	@Bean
	public Product aaa() {
		Battery battery = new Battery("AAA", 2.5);
		battery.setReachargable(true);
		return battery;
	}

	@Bean
	public Product cdrw() {
		Disc cdrw = new Disc("CD-RW", 1.5);
		cdrw.setCapacity(200);
		return cdrw;
	}

	@Bean
	public Product dvdrw() {
		Disc dvdrw = new Disc("DVD-RW", 3.0);
		dvdrw.setCapacity(700);
		dvdrw.setPrice(specialEndOfYearDiscountField*100);
		return dvdrw;
	}

	@Bean
	public BannerLoader bannerLoader() {
		BannerLoader bannerLoader = new BannerLoader();
		bannerLoader.setBanner(resource);
		return bannerLoader;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = 
				new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:messages");
		messageSource.setCacheSeconds(2);
		return messageSource;
	}
	
	@Bean
	public Product aaa1() {
		return ProductCreator.createProductUsingStaticMethod("AAA");
	}
	
	@Bean
	public Product cdrw1(){
		return ProductCreator.createProductUsingStaticMethod("cdrw");
	}
	
	@Bean
	public  Product dvdrw1() {
		return ProductCreator.createProductUsingStaticMethod("dvdrw");
	}
	
	@Bean
	public ProductCreator createProductCreatorFactory() {
		ProductCreator productCreator = new ProductCreator();
		Map<String, Product> products = new HashMap<String, Product>();
		products.put("aaa", new Battery("aaa", 2.4));
		products.put("cdrw", new Disc("cdrw", 1.4));
		products.put("dvdrw", new Disc("dvdrw", 3.4));
		productCreator.setProducts(products);
		return productCreator;
	}
	
	@Bean 
	public Product aaa2() {
		return createProductCreatorFactory().createProductUsingInstanceMethod("aaa");
	}
	
	@Bean
	public Product cdrw2() {
		return createProductCreatorFactory().createProductUsingInstanceMethod("cdrw");
	}
	
	@Bean
	public Product dvdrw2(){
		return createProductCreatorFactory().createProductUsingInstanceMethod("dvdrw");
	}
	
	@Bean
	public DiscountFactoryBean discountFactoryBeanAAA() {
		DiscountFactoryBean factory = new DiscountFactoryBean();
		factory.setProduct(aaa());
		factory.setDiscount(0.1);
		return factory;
	}
	
	@Bean
	public DiscountFactoryBean discountFactoryBeanCDRW() {
		DiscountFactoryBean factory = new DiscountFactoryBean();
		factory.setProduct(cdrw());
		factory.setDiscount(0.4);
		return factory;
	}
	
	@Bean
	public DiscountFactoryBean discountFactoryBeanDVDRW() {
		DiscountFactoryBean factory = new DiscountFactoryBean();
		factory.setProduct(dvdrw());
		factory.setDiscount(0.9);
		return factory;
		
	}
	
	
	
}
