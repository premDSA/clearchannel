package com.cc.cart.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cc.cart.bean.ItemModel;
import com.cc.cart.entity.Item;
import com.cc.cart.repository.ItemDao;
import com.cc.cart.repository.UserDao;

@Component
public class ItemServicesImpl implements ItemServices{

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<ItemModel> listItems() {
		List<Item> itemList = itemDao.getAllItem();
    	List<ItemModel> items = new ArrayList<>();
		for(Item eachItem:itemList) {
	    	items.add(new ItemModel(eachItem.getId(), eachItem.getName(),eachItem.getPrice()));
		}
		return items;
	}

	@Override
	public void addNewItems(Item newItem) {
		itemDao.addNewItem(newItem);
	}

	@Override
	public ItemModel getItemByID(int itemId) {
		// TODO Auto-generated method stub
		Item item = itemDao.getItemByID(itemId);
		ItemModel itemModel = new ItemModel(item.getId(), item.getName(),item.getPrice());
		return itemModel;
	}


}
