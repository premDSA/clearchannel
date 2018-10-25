package com.cc.cart.bean;

import com.cc.cart.entity.Item;
import com.cc.cart.entity.CartOrder;

public class OrderAddModel extends CartOrder{


	private String message;

	public OrderAddModel(int orderId, int cartGroupId, String message) {
		super(orderId, cartGroupId);
		this.message = message;
	}




	
}
