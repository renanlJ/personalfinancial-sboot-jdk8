package com.learning.jdk8.personalfinancial.service;

import com.learning.jdk8.personalfinancial.domain.Distribution;
import com.learning.jdk8.personalfinancial.domain.Salary;
import com.learning.jdk8.personalfinancial.repository.DistributionRepository;
import com.learning.jdk8.personalfinancial.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class FinanceService {
    
    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private DistributionRepository distributionRepository;

    public Map<String, BigDecimal> calculateDistribution(Salary salary) {
        salaryRepository.save(salary); // Salva o salário

        BigDecimal salaryAmount = salary.getAmount();
        Map<String, BigDecimal> distribution = new HashMap<>();

        // Calcula as distribuições
        distribution.put("Essential Costs", salaryAmount.multiply(BigDecimal.valueOf(0.55)).setScale(2));
        distribution.put("Education", salaryAmount.multiply(BigDecimal.valueOf(0.05)).setScale(2));
        distribution.put("Free", salaryAmount.multiply(BigDecimal.valueOf(0.10)).setScale(2));
        distribution.put("Retirement", salaryAmount.multiply(BigDecimal.valueOf(0.10)).setScale(2));
        distribution.put("Future Goals", salaryAmount.multiply(BigDecimal.valueOf(0.20)).setScale(2));

        // Salva as distribuições
        distribution.forEach((category, amount) -> {
            Distribution dist = new Distribution();
            dist.setSalary(salary);
            dist.setCategory(category);
            dist.setAmount(amount);
            distributionRepository.save(dist);
        });

        return distribution;
    }
}