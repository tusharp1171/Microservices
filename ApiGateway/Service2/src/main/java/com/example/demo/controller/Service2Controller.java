package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class Service2Controller {

    @GetMapping("/api1")
    public String getApi1() {
        return "Response from Service 2 - API 1";
    }

    @GetMapping("/api2")
    public String getApi2() {
        return "Response from Service 2 - API 2";
    }

    @GetMapping("/api3")
    public String getApi3() {
        return "Response from Service 2 - API 3";
    }
}
