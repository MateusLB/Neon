package com.neon.arthurabreu.neon.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.neon.arthurabreu.neon.API.APIClient;
import com.neon.arthurabreu.neon.API.APIService;
import com.neon.arthurabreu.neon.Adapters.GetTransfersAdapter;
import com.neon.arthurabreu.neon.Model.ContactsArray;
import com.neon.arthurabreu.neon.Model.Transactions;
import com.neon.arthurabreu.neon.R;

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

    int sum;

    @BindView(R.id.list_view)
    ListView _listView;

    GetTransfersAdapter getTransfersAdapter;
    ArrayList<Transactions> transactionsArrayList;

    ContactsArray contactsArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ButterKnife.bind(this);

        transactionsArrayList = new ArrayList<>();

        contactsArray = new ContactsArray();

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

                for(int i = 0; i < response.body().size(); i++){
                    transactionsArrayList.add(response.body().get(i));
                }


                //Loop through response and contacts to get the sum of money deposited
                for (int i = 0; i < transactionsArrayList.size(); i++)
                {
                    for (int j = 0; j < 15; j++){
                        if (transactionsArrayList.get(i).getClienteId() == Integer.parseInt(contactsArray.getContactsArrayList().get(j).getClientId())) {

                            sum = contactsArray.getContactsArrayList().get(j).getSum();

                            sum += transactionsArrayList.get(i).getValor();

                            contactsArray.getContactsArrayList().get(j).setSum(sum);

                            System.out.println(contactsArray.getContactsArrayList().get(j).getName());
                            System.out.println(contactsArray.getContactsArrayList().get(j).getSum());
                        }
                    }
                }

                getTransfersAdapter = new GetTransfersAdapter(
                        getApplicationContext(),
                        R.layout.list_custom_transactions,
                        contactsArray.getContactsArrayList());

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
