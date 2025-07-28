package com.classicmodels.classicmodels.service.customer;

import com.classicmodels.classicmodels.entities.Customer;
import com.classicmodels.classicmodels.repository.CustomerRepository;
import com.classicmodels.classicmodels.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
