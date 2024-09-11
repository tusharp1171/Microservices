package com.example.consumerservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.consumerservice.configuration.FeignClientConfiguration;

@FeignClient(name = "serviceBClient", url = "http://localhost:8081", configuration = FeignClientConfiguration.class)
public interface ServiceBClient {
	@GetMapping("/api/data/{id}")
    String getData(@PathVariable("id") int id);

    @PostMapping("/api/data")
    String createData(@RequestBody String data);

    @PutMapping("/api/data/{id}")
    String updateData(@PathVariable("id") int id, @RequestBody String newData);

    @DeleteMapping("/api/data/{id}")
    String deleteData(@PathVariable("id") int id);
}