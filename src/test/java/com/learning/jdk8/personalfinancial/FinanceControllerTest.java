package com.learning.jdk8.personalfinancial;

import com.learning.jdk8.personalfinancial.controller.FinanceController;
import com.learning.jdk8.personalfinancial.domain.Salary;
import com.learning.jdk8.personalfinancial.service.FinanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class FinanceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FinanceService financeService;

    @InjectMocks
    private FinanceController financeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(financeController).build();
    }

    @Test
    public void testCalculateDistribution() throws Exception {
        Salary salary = new Salary();
        salary.setAmount(BigDecimal.valueOf(3000.00));

        Map<String, BigDecimal> distribution = new HashMap<>();
        distribution.put("Essential Costs", BigDecimal.valueOf(1650.00));
        distribution.put("Education", BigDecimal.valueOf(150.00));
        distribution.put("Free", BigDecimal.valueOf(300.00));
        distribution.put("Retirement", BigDecimal.valueOf(300.00));
        distribution.put("Future Goals", BigDecimal.valueOf(600.00));

        when(financeService.calculateDistribution(any(Salary.class))).thenReturn(distribution);

        mockMvc.perform(post("/api/finance/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"amount\": 3000.00}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$['Essential Costs']").value(1650.00))
                .andExpect(jsonPath("$.Education").value(150.00))
                .andExpect(jsonPath("$.Free").value(300.00))
                .andExpect(jsonPath("$.Retirement").value(300.00))
                .andExpect(jsonPath("$['Future Goals']").value(600.00));
    }
}