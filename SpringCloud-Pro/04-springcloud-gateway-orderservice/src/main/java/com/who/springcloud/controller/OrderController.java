package com.who.springcloud.controller;

import com.who.springcloud.model.Order;
import com.who.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/detail/{id}")
    public Object detail(@PathVariable Integer id){
        System.out.println("--toget--");
        Order order = orderService.queryOrderById(id);
        return order;
    }
}
