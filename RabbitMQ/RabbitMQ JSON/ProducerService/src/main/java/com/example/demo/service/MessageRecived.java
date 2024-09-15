package com.example.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.RabbitMQConfig;

@Service
public class MessageRecived {
	@RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(String message) {
		
		System.out.println("the message is "+message);
	
	}
}
