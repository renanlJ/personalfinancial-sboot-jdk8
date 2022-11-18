package com.learning.jdk8.personalfinancial;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.jdk8.personalfinancial.controller.PaymentController;
import com.learning.jdk8.personalfinancial.domain.Payment;
import com.learning.jdk8.personalfinancial.domain.PaymentDescription;
import com.learning.jdk8.personalfinancial.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentController.class)
public class PaymentTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;

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
    public void shouldGet7030Rule() throws Exception {
        String payload = "{'paymentDate':'01/08/2022','paymentDescription':'SALARY'}";
        this.mockMvc.perform(
                        get("/payment")
                            .contentType(MediaType.APPLICATION_JSON).content(payload))
                    .andExpect(
                            content().string("{'essential':'5500','education':'500','free':'1000','retirement':'1000','longTerm':'2000'}"));
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
