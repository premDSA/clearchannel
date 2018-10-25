package com.cc.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cc.cart.bean.ItemAddModel;
import com.cc.cart.bean.ItemModel;
import com.cc.cart.controller.bean.CartItem;
import com.cc.cart.entity.Item;
import com.cc.cart.services.CartServices;
import com.cc.cart.services.ItemServices;

@Controller
@SessionAttributes(value = {"cartID"})
public class CartController {

	@Autowired
	ItemServices itemServices;
	
	@Autowired
	CartServices cartServices;
	
	
	@PostMapping("/addItemToCart")
    @ResponseBody
    public ItemAddModel addItemToCart(@RequestBody CartItem newCardItem) {
		ItemAddModel itemAddModel;
        try {
        	cartServices.addItemToCart(newCardItem.getItemId(),newCardItem.getCartId());
			ItemModel newItem = itemServices.getItemByID(newCardItem.getItemId());
			itemAddModel = new ItemAddModel(newItem.getId(), newItem.getName(), newItem.getPrice(), "New item added successfully");
		} catch (Exception e) {
			itemAddModel = new ItemAddModel(0, null, 0, "Failed to add an item to the cart");
			}
		return itemAddModel;
    }
	
	@PostMapping("/deleteItemFromCart")
    @ResponseBody
    public ItemAddModel deleteItemFromCart(@RequestBody CartItem newCardItem) {
		ItemAddModel itemAddModel;
        try {
        	cartServices.deleteItemToCart(newCardItem.getItemId(), newCardItem.getCartId());
			ItemModel newItem = itemServices.getItemByID(newCardItem.getItemId());
			itemAddModel = new ItemAddModel(newItem.getId(), newItem.getName(), newItem.getPrice(), "Item deleted successfully");
		} catch (Exception e) {
			itemAddModel = new ItemAddModel(0, null, 0, "Failed to add an item to the cart");
			}
		return itemAddModel;
    }
}
