package com.example.OrderService.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class UserServiceClient {

    private final WebClient webClient;

    @Value("${userService.url}")
    private String userServiceUrl;
    public UserServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(userServiceUrl).build();
    }

    public Mono<String> getUser(Long id) {
        return this.webClient.get()
                             .uri("/users/{id}", id)
                             .retrieve()
                             .bodyToMono(String.class);
    }
    
 // POST request
    public Mono<String> createUser(String user) {
        return this.webClient.post()
                             .uri("/users")
                             .bodyValue(user)
                             .retrieve()
                             .bodyToMono(String.class);
    }

    // PUT request
    public Mono<String> updateUser(Long id, String user) {
        return this.webClient.put()
                             .uri("/users/{id}", id)
                             .bodyValue(user)
                             .retrieve()
                             .bodyToMono(String.class);
    }

    // DELETE request
    public Mono<String> deleteUser(Long id) {
        return this.webClient.delete()
                             .uri("/users/{id}", id)
                             .retrieve()
                             .bodyToMono(String.class);
    }
    
}
