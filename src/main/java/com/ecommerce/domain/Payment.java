package com.ecommerce.domain;

import com.ecommerce.enums.PaymentStatus;
import com.ecommerce.enums.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private BigDecimal amount;

    private LocalDateTime paidDate;
    private LocalDateTime pendentDate;
    private LocalDateTime deniedDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer installments;
}
