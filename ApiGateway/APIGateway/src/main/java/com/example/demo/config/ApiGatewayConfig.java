package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route("service2", r -> r.path("/service2/**")
	                .uri("http://localhost:8082"))
//	        .route("userManagementServiceSwagger", r -> r.path("/swagger-ui/**")
//	                .uri("http://localhost:8081/swagger-ui"))
	        .route("service1", r -> r.path("/service1/**")
	                .uri("http://localhost:8081"))
	        .build();
	}}	