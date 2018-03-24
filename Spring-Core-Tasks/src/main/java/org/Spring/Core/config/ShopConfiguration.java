package org.Spring.Core.config;

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
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("org.Spring.Core.Scope")
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
}
