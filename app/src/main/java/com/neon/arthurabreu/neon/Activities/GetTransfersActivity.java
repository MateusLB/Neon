package com.neon.arthurabreu.neon.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.neon.arthurabreu.neon.API.APIClient;
import com.neon.arthurabreu.neon.API.APIService;
import com.neon.arthurabreu.neon.Adapters.GetTransfersAdapter;
import com.neon.arthurabreu.neon.Adapters.ListAdapter;
import com.neon.arthurabreu.neon.Model.Transactions;
import com.neon.arthurabreu.neon.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.neon.arthurabreu.neon.Activities.SendMoneyActivity.TOKEN;


/**
 * Created by desenv on 17/08/17.
 */

public class GetTransfersActivity extends AppCompatActivity{

    public static final String TAG = "GetTransfersActivity";

    @BindView(R.id.list_view)
    ListView _listView;

    GetTransfersAdapter getTransfersAdapter;
    ArrayList<Transactions> transactionsArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ButterKnife.bind(this);

        transactionsArrayList = new ArrayList<>();

        //Get the Token saved for general use
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String token = sharedPref.getString(TOKEN, "Nothing here");

        loadData(token);
    }

    public void loadData(String token)
    {
        final APIService apiService =
                APIClient.getClient().create(APIService.class);

        Call<List<Transactions>> call = apiService.getTransactions(token);
        call.enqueue(new Callback<List<Transactions>>(){
            @Override
            public void onResponse(Call<List<Transactions>> call, Response<List<Transactions>> response) {

                transactionsArrayList.clear();

//                String test = response.body().get(0).getData().toString();
//                Log.d(TAG, "GetTransactions Api Response.body: " + test);


                for(int i = 0; i < response.body().size(); i++){
                    transactionsArrayList.add(response.body().get(i));
                }

                getTransfersAdapter = new GetTransfersAdapter(
                        getApplicationContext(),
                        R.layout.list_custom_transactions,
                        transactionsArrayList);

                _listView.setAdapter(getTransfersAdapter);
                getTransfersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Transactions>> call, Throwable t) {
                System.out.println("Failed!" + t.toString());
            }
        });
    }
}
