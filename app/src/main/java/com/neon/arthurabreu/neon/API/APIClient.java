package com.neon.arthurabreu.neon.API;

import android.content.Context;

import com.neon.arthurabreu.neon.Utils.Constants;
import com.neon.arthurabreu.neon.Utils.Preferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private APIService apiService;

    public static final String BASE_URL = "http://processoseletivoneon.azurewebsites.net";

    String token = "";
    Context context;
    Preferences preferences;

    public APIClient(Context context)
    {
        this.context = context;

        retrievePreferenceLoginToken();

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .header("Token", token)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(APIService.class);

    }

    private String retrievePreferenceLoginToken() {

        String token = "";

        if (preferences != null)
            token = preferences.getString(Constants.LOGIN);

        return token;
    }

    public APIService getApiService()
    {
        return apiService;
    }
}
