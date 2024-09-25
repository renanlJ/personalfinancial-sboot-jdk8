package com.learning.jdk8.personalfinancial.repository;

import com.learning.jdk8.personalfinancial.domain.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
}