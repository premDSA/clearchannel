package com.cc.cart.bean;

import com.cc.cart.entity.Item;

public class ItemAddModel extends Item{

	public ItemAddModel(int id, String name, int price, String message) {
		super(id, name, price);
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
