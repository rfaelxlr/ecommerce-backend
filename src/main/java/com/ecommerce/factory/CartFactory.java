package com.ecommerce.factory;

import com.ecommerce.domain.Cart;
import com.ecommerce.domain.Store;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CartFactory {

    public Cart createEmptyCart(Store store) {
        return Cart.builder()
                .total(BigDecimal.ZERO)
                .store(store)
                .shipmentCost(BigDecimal.ZERO).build();
    }
}
