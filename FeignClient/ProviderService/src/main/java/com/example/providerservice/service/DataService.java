package com.example.providerservice.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class DataService {

    // Mocked data storage
    private final Map<Integer, String> dataStore = new ConcurrentHashMap<>();

    public String getDataById(int id) {
        return dataStore.get(id);
    }

    public String saveData(String data) {
        int id = dataStore.size() + 1; // Simple ID generation
        dataStore.put(id, data);
        return "Data created with ID: " + id;
    }

    public boolean updateData(int id, String newData) {
        if (dataStore.containsKey(id)) {
            dataStore.put(id, newData);
            return true;
        }
        return false;
    }

    public boolean deleteData(int id) {
        return dataStore.remove(id) != null;
    }
}