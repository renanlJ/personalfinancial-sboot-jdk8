package com.learning.jdk8.personalfinancial.controller;

import com.learning.jdk8.personalfinancial.domain.Salary;
import com.learning.jdk8.personalfinancial.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {
    
    @Autowired
    private FinanceService financeService;

    @PostMapping("/calculate")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, BigDecimal> calculate(@RequestBody Salary salary) {
        return financeService.calculateDistribution(salary);
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String test() {
        return "test success!";
    }
}
