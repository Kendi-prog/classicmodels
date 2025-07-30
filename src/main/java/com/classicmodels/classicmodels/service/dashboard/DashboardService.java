package com.classicmodels.classicmodels.service.dashboard;

import com.classicmodels.classicmodels.DTOs.SummaryDTO;
import com.classicmodels.classicmodels.repository.CustomerRepository;
import com.classicmodels.classicmodels.repository.OrderRepository;
import com.classicmodels.classicmodels.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public SummaryDTO getSummary(){
        long customers = customerRepository.count();
        long orders = orderRepository.count();
        long products = productRepository.count();

        return new  SummaryDTO(customers, orders, products);
    }
}
