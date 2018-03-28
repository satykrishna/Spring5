package org.Spring.Core.Factory;

import org.Spring.model.Product;
import org.springframework.beans.factory.config.AbstractFactoryBean;

public class DiscountFactoryBean extends AbstractFactoryBean<Product> {

	private Product product;
	private double discount;

	@Override
	public Class<?> getObjectType() {
		return product.getClass();
	}

	@Override
	protected Product createInstance() throws Exception {
		product.setPrice((1-discount)*product.getPrice());
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
