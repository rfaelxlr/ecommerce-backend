package com.ecommerce.factory;

import com.ecommerce.domain.Cart;
import com.ecommerce.domain.Customer;
import com.ecommerce.domain.Store;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CartFactory {

    public Cart createEmptyCart(Store store, Customer customer) {
        return Cart.builder()
                .total(BigDecimal.ZERO)
                .store(store)
                .customer(customer)
                .shipmentCost(BigDecimal.ZERO).build();
    }
}
