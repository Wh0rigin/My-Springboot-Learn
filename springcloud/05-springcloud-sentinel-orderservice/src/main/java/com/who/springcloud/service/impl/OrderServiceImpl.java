package com.who.springcloud.service.impl;

import com.who.springcloud.clients.UserClient;
import com.who.springcloud.model.Order;
import com.who.springcloud.model.User;
import com.who.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserClient userClient;

    @Override
    public Order queryOrderById(Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setName("computer");
        order.setDate("2022-2-24");
        order.setUid(1);
        User user = userClient.findUserById(order.getUid());
        order.setUser(user);
        return order;
    }
}
