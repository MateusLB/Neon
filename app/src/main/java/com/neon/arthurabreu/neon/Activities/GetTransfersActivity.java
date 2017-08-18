package com.neon.arthurabreu.neon.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.neon.arthurabreu.neon.API.APIClient;
import com.neon.arthurabreu.neon.API.APIService;
import com.neon.arthurabreu.neon.Adapters.GetTransfersAdapter;
import com.neon.arthurabreu.neon.Model.Contacts;
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
                    for (int j = 0; j < contactsArray.getContactsArrayList().size(); j++){

                        if (transactionsArrayList.get(i).getClienteId() == Integer.parseInt(contactsArray.getContactsArrayList().get(j).getClientId())) {

                            //Get the sum value from inside the array positio j
                            sum = contactsArray.getContactsArrayList().get(j).getSum();

                            //Set the sum to the value it has + the new value found for that id
                            sum += transactionsArrayList.get(i).getValor();

                            //Set sum value inside the array
                            contactsArray.getContactsArrayList().get(j).setSum(sum);

                            //For simple tests purpose
//                            System.out.println(contactsArray.getContactsArrayList().get(j).getName());
//                            System.out.println(contactsArray.getContactsArrayList().get(j).getSum());
                        }
                    }
                }

                //Create new ArrayList for the listview display, but without the ones that doesn't have money deposited
                ArrayList<Contacts> arrayList = new ArrayList<>();

                for (Contacts contacts : contactsArray.getContactsArrayList())
                {
                    if (contacts.getSum() != 0)
                    {
                        arrayList.add(contacts);
                    }
                }

                getTransfersAdapter = new GetTransfersAdapter(
                        getApplicationContext(),
                        R.layout.list_custom_transactions,
                        arrayList);

                _listView.setAdapter(getTransfersAdapter);
                getTransfersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Transactions>> call, Throwable t) {
                System.out.println("Failed!" + t.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
