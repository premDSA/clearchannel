package com.cc.cart.repository;

import java.util.List;

import com.cc.cart.entity.Cart;
import com.cc.cart.entity.Item;

public interface CartDao {
	
	void deleteItemToCart(int itemID, int cartId);
	
	List<Integer> listAllItemsInCart(int cartID);

	int createCartGroupId();

	void addItemToCart(Cart cartEntity);
}
