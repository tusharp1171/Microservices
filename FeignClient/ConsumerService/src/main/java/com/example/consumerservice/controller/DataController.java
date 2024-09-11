package com.example.consumerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumerservice.service.ServiceBClient;
@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private ServiceBClient serviceBClient;

    @GetMapping("/fetch-data/{id}")
    public String fetchDataFromServiceB(@PathVariable int id) {
        return serviceBClient.getData(id);
    }

    @PostMapping("/create-data")
    public String createDataInServiceB(@RequestBody String data) {
        return serviceBClient.createData(data);
    }

    @PutMapping("/update-data/{id}")
    public String updateDataInServiceB(@PathVariable int id, @RequestBody String newData) {
        return serviceBClient.updateData(id, newData);
    }

    @DeleteMapping("/delete-data/{id}")
    public String deleteDataInServiceB(@PathVariable int id) {
        return serviceBClient.deleteData(id);
    }
}