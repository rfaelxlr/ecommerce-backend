package com.ecommerce.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String ean;
    private BigDecimal price;
    private boolean active;
    private LocalDateTime creationDate;
    private LocalDateTime modifiedDate;
}
