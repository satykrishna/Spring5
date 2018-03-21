package org.Spring.Core.config;

import org.Spring.model.Battery;
import org.Spring.model.Disc;
import org.Spring.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfiguration {

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
}
