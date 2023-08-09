package com.learning.jdk8.personalfinancial.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Rule7030 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal essential;
    private BigDecimal education;
    private BigDecimal free;
    private BigDecimal retirement;
    private BigDecimal longTerm;
    @OneToOne(mappedBy = "rule7030")
    @JsonIgnore
    private Payment payment;

    public Rule7030(Payment payment){
        setPayment(payment);
        setEducation(payment);
        setEssential(payment);
        setRetirement(payment);
        setLongTerm(payment);
        setFree(payment);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    private void setEducation(Payment payment) {
        this.education = payment.getValue().multiply(new BigDecimal("0.05"));
    }

    private void setEssential(Payment payment) {
        this.essential = payment.getValue().multiply(new BigDecimal("0.55"));
    }

    private void setRetirement(Payment payment) {
        this.retirement = payment.getValue().multiply(new BigDecimal("0.10"));
    }

    private void setLongTerm(Payment payment) {
        this.longTerm = payment.getValue().multiply(new BigDecimal("0.20"));
    }

    private void setFree(Payment payment) {
        this.free = payment.getValue().multiply(new BigDecimal("0.10"));
    }
}
