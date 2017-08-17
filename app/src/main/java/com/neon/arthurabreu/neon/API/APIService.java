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

//    @FormUrlEncoded
//    @POST("SendMoney")
//    Call<Task> sendMoney(@Field("ClienteId") String clientId,
//                         @Field("Valor") Double value,
//                         @Field("Token") String token);


    @POST("SendMoney")
    Call<Task> sendMoney(@Body Task task);
}
