package com.example.demo.configuration;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "message_queue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, false);
    }
}
