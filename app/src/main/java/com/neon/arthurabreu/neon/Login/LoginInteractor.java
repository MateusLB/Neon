package com.neon.arthurabreu.neon.Login;

import android.content.Context;

import com.neon.arthurabreu.neon.API.APIClient;
import com.neon.arthurabreu.neon.Model.Contacts;
import com.neon.arthurabreu.neon.R;
import com.neon.arthurabreu.neon.Utils.CheckNetworkAvailability;
import com.neon.arthurabreu.neon.Utils.Constants;
import com.neon.arthurabreu.neon.Utils.Preferences;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by af2g on 12/12/2017.
 */

public class LoginInteractor implements LoginContracts.InteractorInput {

    LoginContracts.InteractorOutput interactorOutput;
    Context context;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();
    APIClient apiClient;
    String token = "";
    Preferences preferences;

    public LoginInteractor(LoginContracts.InteractorOutput interactorOutput) {
        this.interactorOutput = interactorOutput;
        contactsArrayList = new ArrayList<>();
    }

//    @Override
//    public void fetchContacts(Context context) {
//
//        this.context = context;
//
//        if (contactsArrayList == null) {
//            interactorOutput.showLoading();
//
//            contactsArrayList.add(new Contacts(1, "1", "202-555-0121", "Ned Stark", R.drawable.ned, 0));
//            contactsArrayList.add(new Contacts(2, "2", "202-555-0193", "Robert Baratheon", R.drawable.robert, 0));
//            contactsArrayList.add(new Contacts(3, "3", "202-555-0158", "Jaime Lannister", R.drawable.jaime, 0));
//            contactsArrayList.add(new Contacts(4, "4", "202-555-0129", "Catelyn Stark", R.drawable.catelyn, 0));
//            contactsArrayList.add(new Contacts(5, "5", "202-555-0182", "Cersei Lannister", R.drawable.cersei, 0));
//            contactsArrayList.add(new Contacts(6, "6", "202-555-0149", "Jorah Mormont", R.drawable.jorah, 0));
//            contactsArrayList.add(new Contacts(7, "7", "506-900-6948", "Petyr Baelish", R.drawable.petyr, 0));
//            contactsArrayList.add(new Contacts(8, "8", "269-943-0197", "Jon Snow", R.drawable.jon, 0));
//            contactsArrayList.add(new Contacts(9, "9", "125-794-1294", "Sansa Stark", R.drawable.sansa, 0));
//            contactsArrayList.add(new Contacts(10, "10", "423-890-3212", "Arya Stark", R.drawable.arya, 0));
//            contactsArrayList.add(new Contacts(11, "11", "979-772-7700", "Bran Stark", R.drawable.bran, 0));
//            contactsArrayList.add(new Contacts(12, "12", "441-493-0618", "Davos Seaworth", R.drawable.davos, 0));
//            contactsArrayList.add(new Contacts(13, "13", "818-723-0802", "Bronn", R.drawable.bronn, 0));
//            contactsArrayList.add(new Contacts(14, "14", "938-891-9998", "Tyrion Lannister", R.drawable.tyrion, 0));
//            contactsArrayList.add(new Contacts(15, "15", "128-604-5116", "Margaery Tyrell ", R.drawable.margaery, 0));
//
//            interactorOutput.hideLoading();
//        } else {
//            interactorOutput.showAlertError(context.getString(R.string.contactsNotAvailable));
//        }
//    }

    @Override
    public void login(String name, String email) {

        if (CheckNetworkAvailability.isNetworkAvailable(context)) {

            Call<String> call = apiClient.getApiService().getToken(name, email);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    token = response.body().toString();
                    preferences.setString(Constants.LOGIN, token);
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    System.out.println(context.getString(R.string.failed) + t.toString());
                    System.out.println(call.request().url().toString());
                    interactorOutput.apiError(context.getString(R.string.error) + t.toString());
                }
            });
        }
    }
}
