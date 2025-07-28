package com.classicmodels.classicmodels.service.payment;

import com.classicmodels.classicmodels.entities.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(Integer customerNumber, String checkNumber);
}

