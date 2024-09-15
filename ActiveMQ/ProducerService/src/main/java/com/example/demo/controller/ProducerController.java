package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class ProducerController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/message")
    public String sendMessage(@RequestParam String message) {
        jmsTemplate.convertAndSend("simple.queue", message);
        return "Message sent!";
    }
}