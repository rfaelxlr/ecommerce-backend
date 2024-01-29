package com.ecommerce.queue;

import com.ecommerce.domain.dto.OrderDTO;
import com.ecommerce.enums.OrderStatus;
import com.ecommerce.service.OrderService;
import com.ecommerce.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitMQConsumer {
    private final MapperUtil mapperUtil;
    private final OrderService orderService;
    @RabbitListener(queues = {"${order.queue.name}"})
    public void orderPendentListener(@Payload String message) {
        OrderDTO orderDTO = mapperUtil.mapFromJson(message, OrderDTO.class);
        System.out.println("listenerrr");
        if(orderDTO.getStatus().equals(OrderStatus.NEW))
            orderService.updateOrderStatus(orderDTO.getId(), OrderStatus.PENDENT);
    }
}
