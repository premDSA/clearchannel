package com.cc.cart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cc.cart.entity.Cart;
import com.cc.cart.entity.Item;
import com.cc.cart.repository.CartDao;
import com.cc.cart.repository.ItemDao;
@Component
public class CartServicesImpl implements CartServices{

	@Autowired
	private CartDao cartDao;
	
	@Override
	public void deleteItemToCart(int itemID, int cartId) {
		// TODO Auto-generated method stub
		cartDao.deleteItemToCart(itemID, cartId);
	}

	@Override
	public void addItemToCart(int itemID, int cartId) {
		// TODO Auto-generated method stub
		if(cartId > 0) {
			System.out.println(cartId);
		}else {
			cartId = cartDao.createCartGroupId();
			cartId++;
			System.out.println(cartId);
		}
		
		Cart CartEntity =  new Cart(cartId, itemID, 1);
		cartDao.addItemToCart(CartEntity);
	}

	@Override
	public List<Integer> listAllItemsInCart(int cartID) {
		// TODO Auto-generated method stub
		cartDao.listAllItemsInCart(cartID);
		return cartDao.listAllItemsInCart(cartID);
	}

}
