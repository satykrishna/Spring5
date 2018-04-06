package spring.applicationevents.example;

import java.util.Date;

import org.Spring.Core.Scope.ShoppingCart;

public class CheckoutEvent {

	private ShoppingCart cart;
	private Date date;
	
	public CheckoutEvent(ShoppingCart cart, Date date) {
		this.cart = cart;
		this.date = date;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CheckoutEvent [cart=" + cart + ", date=" + date + "]";
	}

}
