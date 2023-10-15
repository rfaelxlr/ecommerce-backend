package com.ecommerce.controller.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDeliveryAreaRequest {
    private Double kilometersDistance;
    private BigDecimal price;
    private boolean active;
}


