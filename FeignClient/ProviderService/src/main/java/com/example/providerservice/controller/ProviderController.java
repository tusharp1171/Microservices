package com.example.providerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.providerservice.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api")
public class ProviderController {

    private static final Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    private DataService dataService;

    @GetMapping("/data/{id}")
    public ResponseEntity<String> getData(@PathVariable int id) {
        try {
            String data = dataService.getDataById(id);
            if (data != null) {
                return ResponseEntity.ok(data);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found");
            }
        } catch (Exception e) {
            logger.error("Error retrieving data for ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve data");
        }
    }

    @PostMapping("/data")
    public ResponseEntity<String> createData(@RequestBody String data) {
        try {
            String createdData = dataService.saveData(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
        } catch (Exception e) {
            logger.error("Error creating data: {}", data, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create data");
        }
    }

    @PutMapping("/data/{id}")
    public ResponseEntity<String> updateData(@PathVariable int id, @RequestBody String newData) {
        try {
            boolean updated = dataService.updateData(id, newData);
            if (updated) {
                return ResponseEntity.ok("Data updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found for ID: " + id);
            }
        } catch (Exception e) {
            logger.error("Error updating data for ID: {} with new data: {}", id, newData, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update data");
        }
    }

    @DeleteMapping("/data/{id}")
    public ResponseEntity<String> deleteData(@PathVariable int id) {
        try {
            boolean deleted = dataService.deleteData(id);
            if (deleted) {
                return ResponseEntity.ok("Data deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found for ID: " + id);
            }
        } catch (Exception e) {
            logger.error("Error deleting data for ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete data");
        }
    }
}
