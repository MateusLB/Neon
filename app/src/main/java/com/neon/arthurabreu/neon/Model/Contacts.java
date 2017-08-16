package com.neon.arthurabreu.neon.Model;

/**
 * Created by desenv on 16/08/17.
 */

public class Contacts {

    int id,  clientId;
    String name, phone;

    public Contacts(int id, int clientId, String phone, String name) {
        this.id = id;
        this.clientId = clientId;
        this.phone = phone;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getPhone() {
        return phone;
    }

    public String setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
