package com.neon.arthurabreu.neon.API;

import com.neon.arthurabreu.neon.Model.Transactions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("/GenerateToken?nome={name}&email={email}")
    Call<String> getToken(@Path("name") String name, @Path("email") String email);

    //Use Call<Void> when no response is expected.
    @FormUrlEncoded
    @POST("SendMoney")
    Call<Void> sendMoney(@Field(value = "ClienteId", encoded = true) String clientId,
                         @Field(value = "Valor", encoded = true) Double value,
                         @Field(value = "Token", encoded = true) String token);

    @GET("/GetTransfers?")
    Call<List<Transactions>> getTransactions(@Query("token") String token);
}
