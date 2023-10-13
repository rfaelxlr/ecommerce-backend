package com.ecommerce.controller.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateOrderRequest {
    @NotNull
    private Long cartId;
}
