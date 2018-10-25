package com.cc.cart.repository;

import com.cc.cart.entity.CartOrder;
import com.cc.cart.entity.Item;

public interface OrderDao {

    void addOrder(CartOrder order);

    int getOrderIdByCartId(int cartID);

    void addOrderDetail(Item eachItem, int orderID);
}
