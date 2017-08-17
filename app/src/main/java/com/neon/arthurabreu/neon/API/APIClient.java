package com.neon.arthurabreu.neon.API;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by desenv on 16/08/17.
 */

public class APIClient {

    public static final String BASE_URL = "http://processoseletivoneon.azurewebsites.net";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("token", "d3fcd0d1-4562-484b-85d6-0ebb260dc4c7")
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            });

            OkHttpClient client = httpClient.build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}
