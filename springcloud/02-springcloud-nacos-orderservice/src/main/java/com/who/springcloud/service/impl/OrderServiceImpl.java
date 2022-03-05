package com.who.springcloud.service.impl;

import com.who.springcloud.model.Order;
import com.who.springcloud.model.User;
import com.who.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order queryOrderById(Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setName("computer");
        order.setDate("2022-2-24");
        order.setUid(1);
        String url = "http://userservice/user/detail/"+order.getUid();
        User user = restTemplate.getForObject(url,User.class);
        order.setUser(user);
        return order;
    }
}
