package com.ecommerce.queue;

import com.ecommerce.util.StringMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitMQSender {
    private RabbitTemplate rabbitTemplate;
    private Queue queue;
    private AmqpTemplate amqpTemplate;

    public void send(Object message) {
        String msg = null;
        try {
            msg = StringMapper.mapper().writeValueAsString(message);
            rabbitTemplate.convertAndSend(this.queue.getName(), msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendToExchange(Object message) {
        String msg = null;
        try {
            msg = StringMapper.mapper().writeValueAsString(message);
            amqpTemplate.convertAndSend("order-exchange", "order-key",msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
