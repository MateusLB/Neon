package com.neon.arthurabreu.neon.API;

import com.neon.arthurabreu.neon.Model.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by desenv on 16/08/17.
 */

public interface APIService {

    @GET("/GenerateToken?nome=Daenerys&email=stormborn@motherofdragons.com")
    Call<String> getToken();

    //Failed!com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected BEGIN_OBJECT but was BOOLEAN at line 1 column 5 path $
    @FormUrlEncoded
    @POST("SendMoney")
    Call<Task> sendMoney(@Field(value = "ClienteId", encoded = true) String clientId,
                         @Field(value = "Valor", encoded = true) Double value,
                         @Field(value = "Token", encoded = true) String token);


    //Response is null
//    @POST("SendMoney")
//    Call<Task> sendMoney(@Body Task task);
}
