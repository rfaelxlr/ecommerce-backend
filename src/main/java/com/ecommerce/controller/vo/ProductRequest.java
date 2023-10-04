package com.ecommerce.controller.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Product product;
    @Transient
    private Long categoryId;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Product {
    @NotEmpty(message = "The name of the product must be filled!")
    private String name;
    @NotEmpty(message = "The ean of the product must be filled!")
    @Size(min = 13, max = 13)
    private String ean;
    @NotNull(message = "The price of the product must be filled!")
    private BigDecimal price;
}
