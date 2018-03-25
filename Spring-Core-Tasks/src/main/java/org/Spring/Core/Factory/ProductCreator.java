package org.Spring.Core.Factory;

import java.util.Map;

import org.Spring.model.Battery;
import org.Spring.model.Disc;
import org.Spring.model.Product;

public class ProductCreator {

	public static Product createProductUsingStaticMethod(String productId) {
		if("aaa".equalsIgnoreCase(productId)) {
			return new Battery("AAA", 1.0);
		}
		else if("cdrw".equalsIgnoreCase(productId)) {
			return new Disc("cdrw", 2.0);
		}
		else if("dvdrw".equalsIgnoreCase(productId)) {
			return new Disc("dvdrw", 3.5);
		}
		throw new IllegalArgumentException("Unknown Product");
	}
	
	private Map<String, Product> products;

	public Map<String, Product> getProducts() {
		return products;
	}

	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}
	
	public Product createProductUsingInstanceMethod(String productId) {
		Product product = products.get(productId);
		if(product == null)
			throw new IllegalArgumentException("Unknown productID "+ productId);
		return product;
	}
	
	
}
