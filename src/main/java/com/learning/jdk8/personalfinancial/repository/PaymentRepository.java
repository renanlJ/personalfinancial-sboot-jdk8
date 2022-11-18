package com.learning.jdk8.personalfinancial.repository;

import com.learning.jdk8.personalfinancial.domain.Payment;
import com.learning.jdk8.personalfinancial.domain.PaymentDescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
    Payment findByPaymentDateAndPaymentDescription(LocalDate paymentDate, PaymentDescription paymentDescription);
}
