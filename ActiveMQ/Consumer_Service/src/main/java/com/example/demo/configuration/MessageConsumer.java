package com.example.demo.configuration;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @JmsListener(destination = "simple.queue")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
        // Process the message
    }
}
