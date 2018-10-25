package com.cc.cart.repository;

import java.util.List;

import com.cc.cart.entity.Item;

public interface ItemDao {

    List<Item> getAllItem();

    void addNewItem(Item newItem);

    List<Item> getAllItemByID(List<Integer> itemIdList);

    Item getItemByID(int itemId);

}
