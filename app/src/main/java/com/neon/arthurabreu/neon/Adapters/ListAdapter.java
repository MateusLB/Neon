package com.neon.arthurabreu.neon.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.neon.arthurabreu.neon.Model.Contacts;
import com.neon.arthurabreu.neon.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by desenv on 16/08/17.
 */

public class ListAdapter extends ArrayAdapter<Contacts> {

    Context context;
    private DialogInterface mListener;


    public ListAdapter(Context context, int resource, ArrayList<Contacts> contactsArrayList, DialogInterface dialoginterface) {
        super(context, R.layout.list_custom_contacts, contactsArrayList);
        this.context = context;
        this.mListener = dialoginterface;
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
            viewHolder = new ListAdapter.ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ListAdapter.ViewHolder) view.getTag();
        }

        //===================================================
        //CELL FILLING
        //===================================================

        viewHolder._contactName.setText(contacts.getName());
        viewHolder._contactPhone.setText(contacts.getPhone());

        Glide.with(context)
                .load(contacts.getResId())
                .into(viewHolder._profile);

        viewHolder._cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mListener != null)
                    mListener.dialogInterface();
            }
        });

        return view;
    }

    //===================================================
    //VIEWHOLDER CLASS
    //===================================================

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cardView)
        CardView _cardView;

        @BindView(R.id.profile)
        ImageView _profile;

        @BindView(R.id.contact_name)
        TextView _contactName;

        @BindView(R.id.contact_phone)
        TextView _contactPhone;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
