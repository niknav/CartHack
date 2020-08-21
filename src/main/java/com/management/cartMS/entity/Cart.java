package com.management.cartMS.entity;



import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;



@Entity

@Table(name="CART")
public class Cart  {
	@EmbeddedId
	private CartId cartId;
	
	 @Column(name = "quantity", nullable = false)
		int quantity;
	 
	 
	 public Cart(CartId cartId, int quantity) {
			super();
			this.cartId = cartId;
			this.quantity = quantity;
		}
	 
	 public Cart() {
			super();
		}
		@Override
		public String toString() {
			return "Cart [cartId=" + cartId + ", quantity=" + quantity + "]";
		}
	
	public CartId getCartId() {
		return cartId;
	}
	public void setCartId(CartId cartId) {
		this.cartId = cartId;
	}
		
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
}