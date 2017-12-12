package com.neon.arthurabreu.neon.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.neon.arthurabreu.neon.Adapters.ListAdapter;
import com.neon.arthurabreu.neon.Model.ContactsArray;
import com.neon.arthurabreu.neon.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsActivity extends AppCompatActivity{


    ListAdapter listAdapter;

    @BindView(R.id.list_view)
    ListView _listView;

    ContactsArray contactsArray;

    //===================================================
    //ONCREATE
    //===================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ButterKnife.bind(this);

        contactsArray = new ContactsArray();
        contactsArray.getContactsArrayList();

        loadData(contactsArray);
    }

    //===================================================
    //FILL ARRAY
    //===================================================

    public void loadData(ContactsArray contactsArray)
    {
        listAdapter = new ListAdapter(
                getApplicationContext(),
                R.layout.list_custom_contacts,
                contactsArray.getContactsArrayList());

        _listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }


}
