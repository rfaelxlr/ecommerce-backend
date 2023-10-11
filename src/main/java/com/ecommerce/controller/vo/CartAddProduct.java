package com.ecommerce.controller.vo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartAddProduct {

    @NotNull
    private Long productId;
    @NotNull
    private Integer quantity;
}
