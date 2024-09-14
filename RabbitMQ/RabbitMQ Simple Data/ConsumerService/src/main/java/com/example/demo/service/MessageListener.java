package com.example.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.configuration.RabbitMQConfig;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Received message from RabbitMQ: " + message);
        // Perform actions with the message
    }
}