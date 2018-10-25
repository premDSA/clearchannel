package com.cc.cart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CartOrder {
	
	public CartOrder(int orderId, int cartGroupId) {
		super();
		this.orderId = orderId;
		this.cartGroupId = cartGroupId;
	}
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@Column
	private int cartGroupId;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCartGroupId() {
		return cartGroupId;
	}
	public void setCartGroupId(int cartGroupId) {
		this.cartGroupId = cartGroupId;
	}
	
}

