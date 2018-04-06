package org.Spring.Core.Scope;

import java.util.ArrayList;
import java.util.List;

import org.Spring.model.Product;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShoppingCart {

	private List<Product> items = 
			new ArrayList<Product>();
	
	public void addItem(Product product) {
		items.add(product);
	}
	
	public void addItems(List<Product> newItems) {
		items.addAll(newItems);
	}
	
	public List<Product> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "ShoppingCart [items=" + items + "]";
	}
	
	
}
