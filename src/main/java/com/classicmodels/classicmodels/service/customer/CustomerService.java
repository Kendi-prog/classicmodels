package com.classicmodels.classicmodels.service.customer;

import com.classicmodels.classicmodels.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
