package com.neon.arthurabreu.neon.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.neon.arthurabreu.neon.API.APIClient;
import com.neon.arthurabreu.neon.API.APIService;
import com.neon.arthurabreu.neon.Model.Task;
import com.neon.arthurabreu.neon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by desenv on 17/08/17.
 */

public class SendMoneyActivity extends AppCompatActivity {

    public static final String TAG = "SendMoneyActivity";

    @BindView(R.id.nameEdt)
    TextView _nameEdt;

    @BindView(R.id.phoneEdt)
    TextView _phoneEdt;

    @BindView(R.id.profile_image)
    ImageView _profile;

    @BindView(R.id.valueEdt)
    EditText _valueEdt;

    @BindView(R.id.btn_sendMoney)
    Button _sendMoney;

    Task task;
    String token, id;
    double value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String name = extras.getString("Name");
        String phone = extras.getString("Phone");
        id = extras.getString("ClientId");
        int i = extras.getInt("Photo");

        _nameEdt.setText(name);
        _phoneEdt.setText(phone);

        Glide.with(this)
                .load(i)
                .into(_profile);

        loadData();

        _sendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                value = Double.parseDouble(_valueEdt.getText().toString());

                sendMoney();

                //todo Validation on click
            }
        });
    }

    public void loadData()
    {
        final APIService apiService =
               APIClient.getClient().create(APIService.class);

        Call<String> call = apiService.getToken();
        call.enqueue(new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                token = response.body().toString();
                Log.d(TAG, "GetToken Api Response.body: " + token);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("Failed!" + t.toString());
            }
        });
    }

    public void sendMoney()
    {
        task = new Task(id, value, token);
        Log.d(TAG, "ID: " + id);
        Log.d(TAG, "TOKEN: " + token);
        Log.d(TAG, "VALUE: " + value);

        final APIService apiService =
                APIClient.getClient().create(APIService.class);

        Call<Void> call = apiService.sendMoney(task.getClientId(), task.getValue(), task.getToken());

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "CreateTask Api Response.isSuccessful: " + response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println("Failed!" + t.toString());
            }
        });
    }
}
