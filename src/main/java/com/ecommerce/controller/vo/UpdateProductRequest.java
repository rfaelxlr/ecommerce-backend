package com.ecommerce.controller.vo;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private ProductUpdate product;
    private Long categoryId;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class ProductUpdate {
    private String name;
    @Size(min = 13, max = 13)
    private String ean;
    private BigDecimal price;
    private boolean active = true;
}
