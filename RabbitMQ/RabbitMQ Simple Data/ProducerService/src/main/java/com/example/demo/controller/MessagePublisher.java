package com.example.demo.controller;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.RabbitMQConfig;

@RestController
@RequestMapping("/api/publish")
public class MessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{message}")
    public String sendMessage(@PathVariable String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);
        return "Message sent to RabbitMQ: " + message;
    }
}
