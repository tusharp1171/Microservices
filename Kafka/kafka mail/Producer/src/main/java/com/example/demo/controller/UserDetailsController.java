package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetails;

@RestController
@RequestMapping("/api/user")
public class UserDetailsController {

    @Autowired
    private KafkaTemplate<String, UserDetails> kafkaTemplate;

    private static final String TOPIC = "user-details-topic";

    @PostMapping("/publish")
    public String publishUserDetails(@RequestBody UserDetails userDetails) {
        kafkaTemplate.send(TOPIC, userDetails);
        return "User details published successfully!";
    }
}