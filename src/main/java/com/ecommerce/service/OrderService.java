package com.ecommerce.service;

import com.ecommerce.controller.vo.CreateOrderRequest;
import com.ecommerce.domain.Cart;
import com.ecommerce.domain.Order;
import com.ecommerce.domain.dto.OrderDTO;
import com.ecommerce.enums.OrderStatus;
import com.ecommerce.exception.NotFoundException;
import com.ecommerce.factory.OrderFactory;
import com.ecommerce.queue.RabbitMQSender;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final OrderFactory orderFactory;
    private final PaymentService paymentService;
    private final RabbitMQSender rabbitMQSender;
    private final MapperUtil mapperUtil;
    public Order createOrder(CreateOrderRequest request) {
        Cart cart = cartService.findById(request.getCartId());
        Order order = orderFactory.createNewOrder(cart);
        orderRepository.save(order);
        paymentService.createPayment(request,order);
        OrderDTO orderDTO = mapperUtil.convert(order, OrderDTO.class);
        rabbitMQSender.sendToExchange(orderDTO);
        return order;
    }

    public Order findById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("Order not Found!"));
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public void updateOrderStatus(Long orderId, OrderStatus status){
        Order order = findById(orderId);
        order.setStatus(status);
        orderRepository.save(order);
    }

}
