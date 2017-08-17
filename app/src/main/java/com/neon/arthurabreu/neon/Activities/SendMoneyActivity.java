package com.neon.arthurabreu.neon.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.neon.arthurabreu.neon.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by desenv on 17/08/17.
 */

public class SendMoneyActivity extends AppCompatActivity {

    @BindView(R.id.nameEdt)
    TextView _nameEdt;

    @BindView(R.id.phoneEdt)
    TextView _phoneEdt;

    @BindView(R.id.profile_image)
    ImageView _profile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String name = extras.getString("Name");
        String phone = extras.getString("Phone");
        int i = extras.getInt("Photo");

        _nameEdt.setText(name);
        _phoneEdt.setText(phone);

        Glide.with(this)
                .load(i)
                .into(_profile);
    }
}
