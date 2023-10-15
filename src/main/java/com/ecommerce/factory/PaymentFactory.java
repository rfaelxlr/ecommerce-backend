package com.ecommerce.factory;

import com.ecommerce.domain.Order;
import com.ecommerce.domain.Payment;
import com.ecommerce.enums.PaymentStatus;
import com.ecommerce.enums.PaymentType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentFactory {

    public Payment createPixPayment(Order order) {
        return Payment.builder()
                .order(order)
                .paymentType(PaymentType.PIX)
                .pendentDate(LocalDateTime.now())
                .status(PaymentStatus.PENDENT)
                .installments(1)
                .build();
    }

    public Payment createCreditCardPayment(Order order, Integer installments) {
        return Payment.builder()
                .order(order)
                .paymentType(PaymentType.CREDIT_CARD)
                .pendentDate(LocalDateTime.now())
                .installments(installments)
                .status(PaymentStatus.PENDENT)
                .build();
    }
}
