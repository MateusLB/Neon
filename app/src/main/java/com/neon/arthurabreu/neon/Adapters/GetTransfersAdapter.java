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
 * Created by desenv on 17/08/17.
 */

public class GetTransfersAdapter extends ArrayAdapter<Contacts> {

    Context context;

    public GetTransfersAdapter(Context context, int resource, ArrayList<Contacts> transactionsArrayList) {
        super(context, R.layout.list_custom_transactions, transactionsArrayList);
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

        final GetTransfersAdapter.ViewHolder viewHolder;
        final View view;
        final Contacts transactions = getItem(position);

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_custom_transactions, parent, false);
            viewHolder = new GetTransfersAdapter.ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (GetTransfersAdapter.ViewHolder) view.getTag();
        }

        //===================================================
        //CELL FILLING
        //===================================================

            viewHolder._contactName.setText(transactions.getName());
            viewHolder._contactPhone.setText(transactions.getPhone());
            viewHolder._contactSum.setText(String.valueOf(transactions.getSum()));

            Glide.with(context)
                    .load(transactions.getResId())
                    .into(viewHolder._profilePic);

        return view;
    }

    //===================================================
    //VIEWHOLDER CLASS
    //===================================================

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.transactionsCv)
        CardView _transactionsCv;

        @BindView(R.id.profilePic)
        ImageView _profilePic;

        @BindView(R.id.contact_name)
        TextView _contactName;

        @BindView(R.id.contact_phone)
        TextView _contactPhone;

        @BindView(R.id.contact_sum)
        TextView _contactSum;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
