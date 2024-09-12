package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class Service1Controller {

    @GetMapping("/api1")
    public String getApi1() {
        return "Response from Service 1 - API 1";
    }

    @GetMapping("/api2")
    public String getApi2() {
        return "Response from Service 1 - API 2";
    }

    @GetMapping("/api3")
    public String getApi3() {
        return "Response from Service 1 - API 3";
    }
}