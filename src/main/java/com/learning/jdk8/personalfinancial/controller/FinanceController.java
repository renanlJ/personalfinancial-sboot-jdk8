package com.learning.jdk8.personalfinancial.controller;

import com.learning.jdk8.personalfinancial.domain.Salary;
import com.learning.jdk8.personalfinancial.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {
    
    @Autowired
    private FinanceService financeService;

    @PostMapping("/calculatenew")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, BigDecimal> calculate(@RequestBody Salary salary) {
        return financeService.calculateDistribution(salary);
    }

<<<<<<< HEAD
    @GetMapping("/version")
    @ResponseStatus(HttpStatus.OK)
    public String getVersion() throws IOException {
        final Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/project.properties"));
        return properties.getProperty("version");
=======
    @GetMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public String test() {
        return "test success!";
>>>>>>> main
    }
}
