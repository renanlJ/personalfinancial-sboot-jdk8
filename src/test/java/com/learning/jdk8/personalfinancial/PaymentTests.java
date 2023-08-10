package com.learning.jdk8.personalfinancial;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.jdk8.personalfinancial.domain.Payment;
import com.learning.jdk8.personalfinancial.domain.PaymentDescription;
import com.learning.jdk8.personalfinancial.repository.PaymentRepository;
import com.learning.jdk8.personalfinancial.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;

    @MockBean
    private PaymentRepository paymentRepository;

    @Test
    public void shouldRegisterPayment() throws Exception {
        Payment payment = getPaymentObject();
        doNothing().when(paymentService).register(payment);
        String paymentJson = asJsonString(payment);

        this.mockMvc.perform(
                        post("/payment")
                            .contentType(MediaType.APPLICATION_JSON).content(paymentJson))
                    .andExpect(status()
                        .isCreated());
    }

    @Test
    public void shouldGetAllPayments() throws Exception {
        when(paymentRepository.findAll()).thenReturn(Collections.singletonList(getPaymentObject()));
        this.mockMvc.perform(
                        get("/payment")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(
                            content().json(asJsonString(Collections.singletonList(getPaymentObject()))));
    }

    public Payment getPaymentObject(){
        return Payment.builder()
                .id(Long.valueOf(1))
                .paymentDescription(PaymentDescription.SALARY)
                .value(new BigDecimal(4000))
                .paymentDate(
                        LocalDate.of(2022, 8, 1))
                .build();
    }

    public static String asJsonString(Object obj){
        String objJsonString = "";

        try {
            ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
            objJsonString = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return objJsonString;
    }

}
