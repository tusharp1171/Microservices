package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "tushar", groupId = "group_id")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
