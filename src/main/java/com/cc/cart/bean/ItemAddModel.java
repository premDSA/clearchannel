package com.cc.cart.bean;

import com.cc.cart.entity.Item;

public class ItemAddModel extends Item {

    public ItemAddModel(final int id, final String name, final int price, final String message) {
        super(id, name, price);
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

}
