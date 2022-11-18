package com.learning.jdk8.personalfinancial.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PaymentDescription paymentDescription;
    @Column(name = "value_payment")
    private BigDecimal value;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate paymentDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rule_id")
    private Rule7030 rule7030;

}
