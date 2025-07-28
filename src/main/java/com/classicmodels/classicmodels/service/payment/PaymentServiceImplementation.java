package com.classicmodels.classicmodels.service.payment;

import com.classicmodels.classicmodels.entities.Payment;
import com.classicmodels.classicmodels.entities.PaymentId;
import com.classicmodels.classicmodels.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImplementation implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImplementation(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Integer customerNumber, String checkNumber) {
        PaymentId id = new PaymentId();
        id.setCustomerNumber(customerNumber);
        id.setCheckNumber(checkNumber);
        return paymentRepository.findById(id).orElse(null);
    }
}

