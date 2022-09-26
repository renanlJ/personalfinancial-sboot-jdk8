package com.learning.jdk8.personalfinancial.service;

import com.learning.jdk8.personalfinancial.domain.Payment;
import com.learning.jdk8.personalfinancial.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void register(Payment payment){
        paymentRepository.save(payment);
    }

}
