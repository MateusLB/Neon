package com.neon.arthurabreu.neon.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by desenv on 16/08/17.
 */

public class Task {

    @SerializedName("ClientId")
    String clientId;

    @SerializedName("Valor")
    double value;

    @SerializedName("token")
    String token;

    public Task(String clientId, String token, double value) {
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

    public double getValue() {
        return value;
    }
}
