package com.neon.arthurabreu.neon.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.neon.arthurabreu.neon.Model.Contacts;
import com.neon.arthurabreu.neon.R;

import java.util.ArrayList;

/**
 * Created by desenv on 16/08/17.
 */

public class ListAdapter extends ArrayAdapter<Contacts> {


    public ListAdapter(Context context, int resource, ArrayList<Contacts> contactsArrayList) {
        super(context, R.layout.list_custom_contacts, contactsArrayList);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    }
}
