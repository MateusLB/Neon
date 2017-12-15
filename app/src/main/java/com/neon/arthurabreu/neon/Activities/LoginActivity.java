package com.neon.arthurabreu.neon.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.neon.arthurabreu.neon.Login.LoginFragment;
import com.neon.arthurabreu.neon.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       LoginFragment loginFragment = new LoginFragment();
       FragmentManager fm = getSupportFragmentManager();
       fm.beginTransaction().add(R.id.container_ll, loginFragment).commit();
    }
}
