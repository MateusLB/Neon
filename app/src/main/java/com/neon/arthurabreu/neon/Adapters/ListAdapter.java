package com.neon.arthurabreu.neon.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.neon.arthurabreu.neon.Model.Contacts;
import com.neon.arthurabreu.neon.R;
import java.util.ArrayList;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by desenv on 16/08/17.
 */

public class ListAdapter extends ArrayAdapter<Contacts> {

    Context context;

    public ListAdapter(Context context, int resource, ArrayList<Contacts> contactsArrayList) {
        super(context, R.layout.list_custom_contacts, contactsArrayList);
        this.context = context;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //===================================================
        //VIEWHOLDER MANAGEMENT
        //===================================================

        ListAdapter.ViewHolder viewHolder;
        View view;
        Contacts contacts = getItem(position);

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_custom_contacts, parent, false);
            viewHolder = new ListAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ListAdapter.ViewHolder) view.getTag();
        }

        //===================================================
        //CELL FILLING
        //===================================================

        viewHolder._contactName.setText(contacts.getName());
        viewHolder._contactPhone.setText(contacts.getPhone());

//        viewHolder.chatsName.setText(chats.getTitle());
//        id = chats.getId();

        return view;
    }

    //===================================================
    //VIEWHOLDER CLASS
    //===================================================

    public class ViewHolder {

        @BindView(R.id.profile)
        ImageView _profile;

        @BindView(R.id.contact_name)
        EditText _contactName;

        @BindView(R.id.contact_phone)
        EditText _contactPhone;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
