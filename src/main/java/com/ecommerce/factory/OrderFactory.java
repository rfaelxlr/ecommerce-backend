package com.ecommerce.factory;

import com.ecommerce.domain.Cart;
import com.ecommerce.domain.Order;
import com.ecommerce.enums.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {

    public Order createNewOrder(Cart cart) {
        return Order.builder()
                .status(OrderStatus.NEW)
                .cart(cart)
                .build();
    }
}
