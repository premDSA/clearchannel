package com.cc.cart.services;

import java.util.List;

import com.cc.cart.bean.ItemModel;
import com.cc.cart.entity.Item;

public interface ItemServices {

    List<ItemModel> listItems();

    ItemModel getItemByID(int itemId);

    void addNewItems(Item newItem);

}
