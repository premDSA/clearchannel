package com.cc.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.cart.bean.ItemAddModel;
import com.cc.cart.bean.ItemModel;
import com.cc.cart.entity.Item;
import com.cc.cart.services.ItemServices;

@Controller
public class ItemController {

    @Autowired
    ItemServices itemServices;

    @GetMapping("/listItems")
    @ResponseBody
    public List<ItemModel> listItems(@RequestParam(name = "name", required = false, defaultValue = "Java Fan") final String name) {
        return itemServices.listItems();
    }

    @PostMapping("/addNewItem")
    @ResponseBody
    public ItemAddModel addNewItem(@RequestBody final Item newItem) {
        ItemAddModel itemAddModel;
        try {
            itemServices.addNewItems(newItem);
            itemAddModel = new ItemAddModel(newItem.getId(), newItem.getName(), newItem.getPrice(), "New item added successfully");
        } catch (final Exception e) {
            itemAddModel = new ItemAddModel(0, null, 0, "Failed to add an item");
        }
        return itemAddModel;
    }
}
