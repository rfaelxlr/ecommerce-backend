package com.ecommerce.configuration;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${order.queue.name}")
    private String orderQueue;

    @Bean
    public Queue orderQueue() {
        return new Queue(orderQueue, true);
    }

    //creating the exchange in java code
    @Bean
    DirectExchange exchange() {
        return new DirectExchange("order-exchange");
    }

    @Bean
    Binding exchangeBinding(Queue orderQueue, DirectExchange exchange) {
        return BindingBuilder.bind(orderQueue).to(exchange).with("order-key");
    }

}
