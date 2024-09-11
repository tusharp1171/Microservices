package com.example.UserService.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Map<Long, String> users = new HashMap<>();
    private Long idCounter = 1L;

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return users.getOrDefault(id, "User not found");
    }

    @PostMapping
    public String createUser(@RequestBody String user) {
        Long id = idCounter++;
        users.put(id, user);
        return "Created user with ID: " + id;
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody String user) {
        if (users.containsKey(id)) {
            users.put(id, user);
            return "Updated user with ID: " + id;
        }
        return "User not found";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (users.remove(id) != null) {
            return "Deleted user with ID: " + id;
        }
        return "User not found";
    }
}