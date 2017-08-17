package com.neon.arthurabreu.neon.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.neon.arthurabreu.neon.Adapters.GetTransfersAdapter;
import com.neon.arthurabreu.neon.Adapters.ListAdapter;
import com.neon.arthurabreu.neon.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by desenv on 17/08/17.
 */

public class GetTransfersActivity extends AppCompatActivity{

    @BindView(R.id.list_view)
    ListView _listView;

    GetTransfersAdapter getTransfersAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ButterKnife.bind(this);

        getTransfersAdapter = new ListAdapter(
                getApplicationContext(),
                R.layout.list_custom_contacts,
                contactsArrayList);

        _listView.setAdapter(getTransfersAdapter);
        getTransfersAdapter.notifyDataSetChanged();
    }
}
