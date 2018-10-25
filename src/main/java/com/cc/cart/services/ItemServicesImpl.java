package com.cc.cart.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cc.cart.bean.ItemModel;
import com.cc.cart.entity.Item;
import com.cc.cart.repository.ItemDao;

@Component
public class ItemServicesImpl implements ItemServices {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<ItemModel> listItems() {
        final List<Item> itemList = itemDao.getAllItem();
        final List<ItemModel> items = new ArrayList<>();
        for (final Item eachItem : itemList) {
            items.add(new ItemModel(eachItem.getId(), eachItem.getName(), eachItem.getPrice()));
        }
        return items;
    }

    @Override
    public void addNewItems(final Item newItem) {
        itemDao.addNewItem(newItem);
    }

    @Override
    public ItemModel getItemByID(final int itemId) {
        // TODO Auto-generated method stub
        final Item item = itemDao.getItemByID(itemId);
        final ItemModel itemModel = new ItemModel(item.getId(), item.getName(), item.getPrice());
        return itemModel;
    }

}
