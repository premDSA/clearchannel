package com.cc.cart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cc.cart.entity.CartOrder;
import com.cc.cart.entity.Item;
import com.cc.cart.repository.CartDao;
import com.cc.cart.repository.ItemDao;
import com.cc.cart.repository.OrderDao;

@Component
public class OrderServicesImpl implements OrderServices{

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Override
	public void addOrder(CartOrder order) {
		orderDao.addOrder(order);
//		int orderID = orderDao.getOrderIdByCartId(order.getCartGroupId());
		List<Integer> itemIdList = cartDao.listAllItemsInCart(order.getCartGroupId());
		List<Item> itemList = itemDao.getAllItemByID(itemIdList);
		for(Item eachItem: itemList) {
			orderDao.addOrderDetail(eachItem, 1);
		}
		// TODO Auto-generated method stub
		
	}

}
