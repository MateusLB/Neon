package com.neon.arthurabreu.neon.Model;

public class Task {

    final String clientId, token;
    final Double value;

    public Task(String clientId, Double value, String token) {
        this.clientId = clientId;
        this.token = token;
        this.value = value;
    }

    public String getClientId() {
        return clientId;
    }

    public String getToken() {
        return token;
    }

    public Double getValue() {
        return value;
    }
}
