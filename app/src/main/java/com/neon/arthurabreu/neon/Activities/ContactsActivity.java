package com.neon.arthurabreu.neon.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.neon.arthurabreu.neon.Adapters.ListAdapter;
import com.neon.arthurabreu.neon.Model.Contacts;
import com.neon.arthurabreu.neon.Model.ContactsArray;
import com.neon.arthurabreu.neon.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by desenv on 16/08/17.
 */

public class ContactsActivity extends AppCompatActivity{

    public static final String SET = "Set";

    ListAdapter listAdapter;

    @BindView(R.id.list_view)
    ListView _listView;

    //===================================================
    //ONCREATE
    //===================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ButterKnife.bind(this);

        loadData();
    }

    //===================================================
    //FILL ARRAY
    //===================================================

    public void loadData()
    {
//        contactsArrayList.add(new Contacts(1, "1", "202-555-0121", "Ned Stark", R.drawable.ned));
//        contactsArrayList.add(new Contacts(2, "2", "202-555-0193", "Robert Baratheon", R.drawable.robert));
//        contactsArrayList.add(new Contacts(3, "3", "202-555-0158", "Jaime Lannister", R.drawable.jaime));
//        contactsArrayList.add(new Contacts(4, "4", "202-555-0129", "Catelyn Stark", R.drawable.catelyn));
//        contactsArrayList.add(new Contacts(5, "5", "202-555-0182", "Cersei Lannister", R.drawable.cersei));
//        contactsArrayList.add(new Contacts(6, "6", "202-555-0149", "Jorah Mormont", R.drawable.jorah));
//        contactsArrayList.add(new Contacts(7, "7", "506-900-6948", "Petyr Baelish", R.drawable.petyr));
//        contactsArrayList.add(new Contacts(8, "8", "269-943-0197", "Jon Snow", R.drawable.jon));
//        contactsArrayList.add(new Contacts(9, "9", "125-794-1294", "Sansa Stark", R.drawable.sansa));
//        contactsArrayList.add(new Contacts(10, "10", "423-890-3212", "Arya Stark", R.drawable.arya));
//        contactsArrayList.add(new Contacts(11, "11", "979-772-7700", "Bran Stark", R.drawable.bran));
//        contactsArrayList.add(new Contacts(12, "12", "441-493-0618", "Davos Seaworth", R.drawable.davos));
//        contactsArrayList.add(new Contacts(13, "13", "818-723-0802", "Bronn", R.drawable.bronn));
//        contactsArrayList.add(new Contacts(14, "14", "938-891-9998", "Tyrion Lannister", R.drawable.tyrion));
//        contactsArrayList.add(new Contacts(15, "15", "128-604-5116", "Margaery Tyrell ", R.drawable.margaery));
        ContactsArray contactsArray = new ContactsArray();
        contactsArray.getContactsArrayList();


        listAdapter = new ListAdapter(
                getApplicationContext(),
                R.layout.list_custom_contacts,
                contactsArray.getContactsArrayList());

        _listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }

    public void saveSharedContactsArray(Set set) {

        // TOKEN - a static String variable like:
        //public static final String TOKEN = "Token";
        SharedPreferences sharedPref = getSharedPreferences(SET, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet(SET, set);
        editor.commit();
    }
}
