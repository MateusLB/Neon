package com.neon.arthurabreu.neon.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.neon.arthurabreu.neon.Adapters.ListAdapter;
import com.neon.arthurabreu.neon.Model.Contacts;
import com.neon.arthurabreu.neon.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by desenv on 16/08/17.
 */

public class ContactsActivity extends AppCompatActivity{

    ArrayList<Contacts> contactsArrayList;
    ListAdapter listAdapter;
    @BindView(R.id.list_view) ListView _listView;

    //===================================================
    //ONCREATE
    //===================================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ButterKnife.bind(this);

        contactsArrayList = new ArrayList<>();

        loadData();
    }

    //===================================================
    //FILL ARRAY
    //===================================================

    public void loadData()
    {
        contactsArrayList.add(new Contacts(1, 1, "202-555-0121", "Ned Stark"));
        contactsArrayList.add(new Contacts(2, 2, "202-555-0193", "Robert Baratheon"));
        contactsArrayList.add(new Contacts(3, 3, "202-555-0158", "Jaime Lannister"));
        contactsArrayList.add(new Contacts(4, 4, "202-555-0129", "Catelyn Stark"));
        contactsArrayList.add(new Contacts(5, 5, "202-555-0182", "Cersei Lannister"));
        contactsArrayList.add(new Contacts(6, 6, "202-555-0149", "Jorah Mormont"));
        contactsArrayList.add(new Contacts(7, 7, "506-900-6948", "Petyr Baelish"));
        contactsArrayList.add(new Contacts(8, 8, "269-943-0197", "Jon Snow"));
        contactsArrayList.add(new Contacts(9, 9, "125-794-1294", "Sansa Stark"));
        contactsArrayList.add(new Contacts(10, 10, "423-890-3212", "Arya Stark"));
        contactsArrayList.add(new Contacts(11, 11, "979-772-7700", "Bran Stark"));
        contactsArrayList.add(new Contacts(12, 12, "441-493-0618", "Davos Seaworth"));
        contactsArrayList.add(new Contacts(13, 13, "818-723-0802", "Bronn"));
        contactsArrayList.add(new Contacts(14, 14, "938-891-9998", "Tyrion Lannister"));
        contactsArrayList.add(new Contacts(15, 15, "128-604-5116", "Margaery Tyrell "));

        listAdapter = new ListAdapter(
                getApplicationContext(),
                R.layout.list_custom_contacts,
                contactsArrayList) {
        };
        _listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

        Log.d("======================>", contactsArrayList.toString());
    }
}
