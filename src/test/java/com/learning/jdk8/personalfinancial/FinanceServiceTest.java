package com.learning.jdk8.personalfinancial;

import com.learning.jdk8.personalfinancial.domain.Distribution;
import com.learning.jdk8.personalfinancial.domain.Salary;
import com.learning.jdk8.personalfinancial.repository.DistributionRepository;
import com.learning.jdk8.personalfinancial.repository.SalaryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.learning.jdk8.personalfinancial.service.FinanceService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FinanceServiceTest {

    @InjectMocks
    private FinanceService financeService;

    @Mock
    private SalaryRepository salaryRepository;

    @Mock
    private DistributionRepository distributionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateDistribution() {
        Salary salary = new Salary();
        salary.setAmount(BigDecimal.valueOf(3000.00).setScale(2));

        Map<String, BigDecimal> expectedDistribution = new HashMap<>();
        expectedDistribution.put("Essential Costs", BigDecimal.valueOf(1650.00).setScale(2));
        expectedDistribution.put("Education", BigDecimal.valueOf(150.00).setScale(2));
        expectedDistribution.put("Free", BigDecimal.valueOf(300.00).setScale(2));
        expectedDistribution.put("Retirement", BigDecimal.valueOf(300.00).setScale(2));
        expectedDistribution.put("Future Goals", BigDecimal.valueOf(600.00).setScale(2));

        when(salaryRepository.save(any(Salary.class))).thenReturn(salary);

        Map<String, BigDecimal> actualDistribution = financeService.calculateDistribution(salary);

        // Verify that the distribution is calculated correctly
        assertEquals(expectedDistribution, actualDistribution);

        // Verify that the distribution entries are saved
        for (Map.Entry<String, BigDecimal> entry : expectedDistribution.entrySet()) {
            verify(distributionRepository, atLeastOnce()).save(any(Distribution.class));
        }
    }
}