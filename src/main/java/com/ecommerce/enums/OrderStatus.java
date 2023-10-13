package com.ecommerce.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    NEW, PENDENT, PAID, READY, DELIVERED, CANCELED;
}
