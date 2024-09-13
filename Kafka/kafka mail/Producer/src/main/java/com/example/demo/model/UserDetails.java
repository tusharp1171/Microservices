package com.example.demo.model;


public class UserDetails {
    private String name;
    private String email;

    // Constructors, Getters, and Setters
    public UserDetails() {}

    public UserDetails(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
