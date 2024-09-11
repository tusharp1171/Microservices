package com.example.OrderService.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderService.service.UserServiceClient;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final UserServiceClient userServiceClient;

    public OrderController(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/{orderId}")
    public Mono<String> getOrder(@PathVariable Long orderId) {
        return Mono.just("Order details for order ID: " + orderId);
    }

    @PostMapping
    public Mono<String> createOrder(@RequestBody String orderDetails) {
        Long userId = 1L; // Example user ID
        return userServiceClient.createUser(orderDetails)
                                .map(response -> "Order created for user: " + response);
    }

    @PutMapping("/{orderId}")
    public Mono<String> updateOrder(@PathVariable Long orderId, @RequestBody String orderDetails) {
        Long userId = 1L; // Example user ID
        return userServiceClient.updateUser(userId, orderDetails)
                                .map(response -> "Order updated for user: " + response);
    }

    @DeleteMapping("/{orderId}")
    public Mono<String> deleteOrder(@PathVariable Long orderId) {
        Long userId = 1L; // Example user ID
        return userServiceClient.deleteUser(userId)
                                .map(response -> "Order deleted for order ID: " + orderId);
    }
}