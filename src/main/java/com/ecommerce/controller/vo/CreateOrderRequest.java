package com.ecommerce.controller.vo;

import com.ecommerce.enums.PaymentType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateOrderRequest {
    @NotNull
    private Long cartId;
    @NotNull
    private PaymentType paymentType;
    @NotNull
    private Integer installments;
}
