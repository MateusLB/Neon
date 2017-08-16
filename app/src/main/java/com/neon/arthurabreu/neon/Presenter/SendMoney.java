package com.neon.arthurabreu.neon.Presenter;

import android.app.Application;
import android.app.Dialog;
import android.util.Log;
import android.widget.Toast;

import com.neon.arthurabreu.neon.API.APIClient;
import com.neon.arthurabreu.neon.API.APIService;
import com.neon.arthurabreu.neon.Activities.ContactsActivity;
import com.neon.arthurabreu.neon.Adapters.DialogInterface;
import com.neon.arthurabreu.neon.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by desenv on 16/08/17.
 */

public class SendMoney {

    public SendMoney() {
    }

    public static final String TAG = "SendMoney";

    public void retrieveToken()
    {
        final APIService apiService =
                APIClient.getClient().create(APIService.class);

        Call<String> call = apiService.getToken();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("Failed!" + t.toString());
            }
        });
    }


}
