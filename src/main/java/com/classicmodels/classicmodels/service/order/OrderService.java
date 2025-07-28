package com.classicmodels.classicmodels.service.order;

import com.classicmodels.classicmodels.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Integer id);
}

