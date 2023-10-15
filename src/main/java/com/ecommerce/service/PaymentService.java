package com.ecommerce.service;

import com.ecommerce.controller.vo.CreateOrderRequest;
import com.ecommerce.domain.Order;
import com.ecommerce.domain.Payment;
import com.ecommerce.factory.PaymentFactory;
import com.ecommerce.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentFactory paymentFactory;


    public void createPayment(CreateOrderRequest request, Order order) {
        Payment payment = switch (request.getPaymentType()) {
            case PIX -> paymentFactory.createPixPayment(order);
            case CREDIT_CARD -> paymentFactory.createCreditCardPayment(order, request.getInstallments());
        };
        paymentRepository.save(payment);
    }
}
