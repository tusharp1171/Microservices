package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class ProductProducer {

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    private static final String TOPIC = "products";

    public void sendProduct(Product product) {
        kafkaTemplate.send(TOPIC, product);
    }
}
