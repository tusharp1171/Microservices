package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserDetails;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @KafkaListener(topics = "user-details-topic", groupId = "email_group")
    public void consumeUserDetails(UserDetails userDetails) {
        System.out.println("Received User Details: " + userDetails);
        sendEmail(userDetails);
    }

    public void sendEmail(UserDetails userDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userDetails.getEmail());
        message.setSubject("Welcome " + userDetails.getName());
        message.setText("Hello " + userDetails.getName() + ",\n\nWelcome to our service!");

        try {
            mailSender.send(message);
            System.out.println("Email sent to: " + userDetails.getEmail());
        } catch (Exception e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}