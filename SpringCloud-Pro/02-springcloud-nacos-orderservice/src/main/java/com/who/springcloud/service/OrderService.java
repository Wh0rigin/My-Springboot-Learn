package com.who.springcloud.service;

import com.who.springcloud.model.Order;

public interface OrderService {
    Order queryOrderById(Integer id);
}
