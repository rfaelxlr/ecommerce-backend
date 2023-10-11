package com.ecommerce.factory;

import com.ecommerce.domain.Cart;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CartFactory {

    public Cart createEmptyCart() {
        return Cart.builder()
                .total(BigDecimal.ZERO)
                .shipmentCost(BigDecimal.ZERO).build();
    }
}
