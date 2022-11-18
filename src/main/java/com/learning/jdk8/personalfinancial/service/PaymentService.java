package com.learning.jdk8.personalfinancial.service;

import com.learning.jdk8.personalfinancial.domain.Payment;
import com.learning.jdk8.personalfinancial.domain.Rule7030;
import com.learning.jdk8.personalfinancial.repository.PaymentRepository;
import com.learning.jdk8.personalfinancial.repository.Rule7030Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void register(Payment payment){
        Rule7030 rule7030 = new Rule7030(payment);
        payment.setRule7030(rule7030);
        rule7030.setPayment(payment);

        paymentRepository.save(payment);
    }

}
