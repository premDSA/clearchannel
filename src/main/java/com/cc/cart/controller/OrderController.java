package com.cc.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.cart.bean.OrderAddModel;
import com.cc.cart.entity.CartOrder;
import com.cc.cart.services.OrderServices;

@Controller
public class OrderController {

    @Autowired
    OrderServices orderServices;

    @PostMapping("/addOrder")
    @ResponseBody
    public OrderAddModel addOrder(@RequestBody final CartOrder order) {
        OrderAddModel orderAddModel;
        try {
            orderServices.addOrder(order);
            orderAddModel = new OrderAddModel(1, order.getCartGroupId(), "Order created successfully");
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            orderAddModel = new OrderAddModel(1, order.getCartGroupId(), "Order creation failed");
        }

        return orderAddModel;
    }

}
