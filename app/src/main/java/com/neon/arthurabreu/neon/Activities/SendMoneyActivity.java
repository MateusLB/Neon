package com.neon.arthurabreu.neon.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

public class SendMoneyActivity extends AppCompatActivity {

    public static final String TAG = "SendMoneyActivity";
    public static final String TOKEN = "Token";

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

        final Intent intent = getIntent();
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


                // TOKEN - a static String variable like:
                //public static final String TOKEN = "Token";
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString(TOKEN, token).commit();
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

        // TOKEN - a static String variable like:
        //public static final String TOKEN = "Token";
        SharedPreferences sharedPref = getSharedPreferences(TOKEN, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(TOKEN, token);
        editor.commit();

        final ProgressDialog progressDialog = new ProgressDialog(SendMoneyActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Sending Money...");
        progressDialog.show();


        final APIService apiService =
                APIClient.getClient().create(APIService.class);

        Call<Void> call = apiService.sendMoney(task.getClientId(), task.getValue(), task.getToken());

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "CreateTask Api Response.isSuccessful: " + response.isSuccessful());

                boolean success = response.isSuccessful();

                if (success){
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    // On complete call either onSendSuccess or onSendFailed
                                    onEventSuccess();
                                    // onSendFailed();
                                    progressDialog.dismiss();
                                }
                            }, 2000);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                System.out.println("Failed!" + t.toString());
                progressDialog.dismiss();
                onEventFailed();
            }
        });
    }

    public void onEventSuccess() {

        Toast.makeText(SendMoneyActivity.this, "Money was successfully sent!", Toast.LENGTH_SHORT).show();
        _sendMoney.setEnabled(true);

        jumpToLogin();
    }

    public void onEventFailed() {
        Toast.makeText(SendMoneyActivity.this, "Couldn't send money, please try again later.", Toast.LENGTH_SHORT).show();
        _sendMoney.setEnabled(true);

        jumpToLogin();
    }

    @Override
    public void onBackPressed() {
        jumpToLogin();
    }

    public void jumpToLogin()
    {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
