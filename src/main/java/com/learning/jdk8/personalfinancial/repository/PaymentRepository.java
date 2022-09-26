package com.learning.jdk8.personalfinancial.repository;

import com.learning.jdk8.personalfinancial.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
