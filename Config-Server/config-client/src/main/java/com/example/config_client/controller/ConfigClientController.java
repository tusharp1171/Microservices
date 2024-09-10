package com.example.config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConfigClientController {
	 @Value("${app.message}")
	    private String message;

	    @GetMapping("/message")
	    public String getMessage() {
	        return message;
	    }

}
