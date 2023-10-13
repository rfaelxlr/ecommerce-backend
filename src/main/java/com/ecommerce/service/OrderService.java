package com.ecommerce.service;

import com.ecommerce.controller.vo.CreateOrderRequest;
import com.ecommerce.domain.Cart;
import com.ecommerce.domain.Order;
import com.ecommerce.factory.OrderFactory;
import com.ecommerce.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final OrderFactory orderFactory;

    public Order createOrder(CreateOrderRequest request) {
        Cart cart = cartService.findById(request.getCartId());
        Order order = orderFactory.createNewOrder(cart);
        return orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
