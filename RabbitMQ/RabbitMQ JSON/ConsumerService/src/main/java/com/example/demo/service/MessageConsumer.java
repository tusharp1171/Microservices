package com.example.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.RabbitMQConfig;
import com.example.demo.model.Message;
import com.example.demo.repo.Repos;

@Service
public class MessageConsumer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	
	@Autowired
	private Repos repos;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(Message message) {
        // Process the message here
        System.out.println("Received message from RabbitMQ: " + message);
        
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY, "messge reecved");
        
        repos.save(message);
    }
}