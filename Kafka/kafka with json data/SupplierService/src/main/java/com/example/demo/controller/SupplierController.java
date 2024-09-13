package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;


@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    private static final String TOPIC = "products";

    @PostMapping("/send")
    public String sendProduct(@RequestBody Product product) {
        kafkaTemplate.send(TOPIC, product);
        return "Product sent to Kafka successfully!";
    }
}