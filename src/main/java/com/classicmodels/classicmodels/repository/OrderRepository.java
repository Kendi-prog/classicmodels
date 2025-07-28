package com.classicmodels.classicmodels.repository;

import com.classicmodels.classicmodels.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
