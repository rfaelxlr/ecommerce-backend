package com.ecommerce.controller;

import com.ecommerce.controller.vo.CreateOrderRequest;
import com.ecommerce.domain.Order;
import com.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody @Valid CreateOrderRequest request) {
        Order order = orderService.createOrder(request);
        return ResponseEntity.created(URI.create("/orders/" + order.getId()))
                .body(order);
    }

    @GetMapping
    public ResponseEntity<?> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

}
