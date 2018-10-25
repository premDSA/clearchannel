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
import com.cc.cart.bean.OrderAddModel;
import com.cc.cart.controller.bean.CartItem;
import com.cc.cart.entity.Item;
import com.cc.cart.entity.CartOrder;
import com.cc.cart.services.CartServices;
import com.cc.cart.services.ItemServices;
import com.cc.cart.services.OrderServices;

@Controller
public class OrderController {

	@Autowired
	OrderServices orderServices;
	
	
	@PostMapping("/addOrder")
    @ResponseBody
    public OrderAddModel addOrder(@RequestBody CartOrder order) {
		OrderAddModel orderAddModel;
		try {
			orderServices.addOrder(order);
			orderAddModel =  new OrderAddModel(1,order.getCartGroupId(), "Order created successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			orderAddModel = new OrderAddModel(1,order.getCartGroupId(), "Order creation failed");
		}

		return orderAddModel;
    }
	
}
