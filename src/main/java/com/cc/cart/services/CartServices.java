package com.cc.cart.services;

import java.util.List;

public interface CartServices {

    void deleteItemToCart(int itemID, int cartId);

    void addItemToCart(int itemID, int cartId);

    List<Integer> listAllItemsInCart(int cartID);

}
