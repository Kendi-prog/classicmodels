package com.classicmodels.classicmodels.service.order;

import com.classicmodels.classicmodels.entities.Order;
import com.classicmodels.classicmodels.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }
}

