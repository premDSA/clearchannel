package com.cc.cart.bean;

import com.cc.cart.entity.CartOrder;

public class OrderAddModel extends CartOrder {

    private final String message;

    public OrderAddModel(final int orderId, final int cartGroupId, final String message) {
        super(orderId, cartGroupId);
        this.message = message;
    }

}
