package com.neon.arthurabreu.neon.API;

import com.neon.arthurabreu.neon.Model.Transactions;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by desenv on 16/08/17.
 */

public interface APIService {

    @GET("/GenerateToken?nome=Daenerys&email=stormborn@motherofdragons.com")
    Call<String> getToken();

    //Use Call<Void> when no response is expected.
    @FormUrlEncoded
    @POST("SendMoney")
    Call<Void> sendMoney(@Field(value = "ClienteId", encoded = true) String clientId,
                         @Field(value = "Valor", encoded = true) Double value,
                         @Field(value = "Token", encoded = true) String token);

    @GET("/GetTransfers?{token}")
    Call<Transactions> getTransactions(@Path("token") String token);
}
