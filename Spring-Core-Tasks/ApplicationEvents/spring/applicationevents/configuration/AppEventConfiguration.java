package spring.applicationevents.configuration;

import java.util.Arrays;
import java.util.List;

import org.Spring.Core.Scope.ShoppingCart;
import org.Spring.model.Battery;
import org.Spring.model.Disc;
import org.Spring.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
		"spring.applicationevents.consumer",
		"spring.applicationevents.publisher"
})
public class AppEventConfiguration {

	public AppEventConfiguration() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public List<Product> newProducts() {
		return Arrays.asList(new  Battery("aaa", 2.4),
				new Disc("CD-Disc", 2.4));
	}
	
	@Bean
	public ShoppingCart shoppingCart() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItems(newProducts());
		return cart;
	}

}
