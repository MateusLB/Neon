package com.neon.arthurabreu.neon.Model;

/**
 * Created by desenv on 16/08/17.
 */

public class Contacts {

    private int id, resId, sum;
    private String name, phone, clientId;


    public Contacts(int id, String clientId, String phone, String name,  int resId, int sum) {
        this.id = id;
        this.clientId = clientId;
        this.phone = phone;
        this.name = name;
        this.resId = resId;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getResId() {
        return resId;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
