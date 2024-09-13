package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class ConsumerService {

    @KafkaListener(topics = "products", groupId = "group_id")
    public void consume(Product product) {
        System.out.println("Consumed product: " + product);
        // You can now access all fields of the product object here
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product Price: " + product.getPrice());
    }
}