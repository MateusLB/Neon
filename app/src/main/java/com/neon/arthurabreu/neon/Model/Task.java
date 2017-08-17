package com.neon.arthurabreu.neon.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by desenv on 16/08/17.
 */

public class Task {

//    @SerializedName("ClientId")
//    String clientId;
//
//    @SerializedName("Valor")
//    Double value;
//
//    @SerializedName("Token")
//    String token;

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
