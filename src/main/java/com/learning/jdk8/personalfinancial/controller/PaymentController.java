package com.learning.jdk8.personalfinancial.controller;

import com.learning.jdk8.personalfinancial.domain.Payment;
import com.learning.jdk8.personalfinancial.domain.PaymentDescription;
import com.learning.jdk8.personalfinancial.domain.Rule7030;
import com.learning.jdk8.personalfinancial.repository.PaymentRepository;
import com.learning.jdk8.personalfinancial.repository.Rule7030Repository;
import com.learning.jdk8.personalfinancial.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerPayment(@RequestBody Payment payment){
        System.out.println(payment);
        paymentService.register(payment);
    }

    @GetMapping
    public Rule7030 get7030Rule(@RequestBody Payment payment){
        Payment payment1 = paymentRepository.findByPaymentDateAndPaymentDescription(
                payment.getPaymentDate(),
                payment.getPaymentDescription());

        return payment1.getRule7030();
    }

}
