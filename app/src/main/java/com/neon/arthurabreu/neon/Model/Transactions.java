package com.neon.arthurabreu.neon.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transactions {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("ClienteId")
    @Expose
    private Integer clienteId;
    @SerializedName("Valor")
    @Expose
    private Integer valor;
    @SerializedName("Token")
    @Expose
    private String token;
    @SerializedName("Data")
    @Expose
    private String data;

    /**
     * No args constructor for use in serialization
     *
     */
    public Transactions() {
    }

    /**
     *
     * @param id
     * @param token
     * @param valor
     * @param clienteId
     * @param data
     */
    public Transactions(Integer id, Integer clienteId, Integer valor, String token, String data) {
        super();
        this.id = id;
        this.clienteId = clienteId;
        this.valor = valor;
        this.token = token;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public Integer getValor() {
        return valor;
    }

    public String getToken() {
        return token;
    }

    public String getData() {
        return data;
    }
}
