package com.neon.arthurabreu.neon.Model;

/**
 * Created by desenv on 16/08/17.
 */

public class Contacts {

    private int id,  clientId;
    private String name, phone;

    public Contacts(int id, int clientId, String phone, String name) {
        this.id = id;
        this.clientId = clientId;
        this.phone = phone;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
