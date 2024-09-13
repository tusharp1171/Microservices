package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class ProductConsumer {

    @KafkaListener(topics = "products", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consume(Product product) {
        System.out.println("Consumed product: " + product.getName());
    }
}
