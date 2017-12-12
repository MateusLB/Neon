package com.neon.arthurabreu.neon.Login;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.neon.arthurabreu.neon.Activities.ContactsActivity;
import com.neon.arthurabreu.neon.R;

/**
 * Created by af2g on 12/12/2017.
 */

public class LoginPresenter implements LoginContracts.Presenter, LoginContracts.InteractorOutput {


    LoginContracts.View view;
    LoginContracts.InteractorInput interactorInput;
    Context context;

    public LoginPresenter(Context context, LoginContracts.View view) {
        this.view = view;
        this.context = context;
        interactorInput = new LoginInteractor(this);
    }

    @Override
    public void sendMoney() {
        interactorInput.fetchContacts(context);

    }

    @Override
    public void events() {

    }

    @Override
    public void onSendSuccess() {
        //Jump to the next activity



    }

    @Override
    public void onSendFailed() {

    }

    @Override
    public void onEventSuccess() {

    }

    @Override
    public void onEventFailed() {

    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void showLoading() {
        view.showLoading();
    }

    @Override
    public void hideLoading() {
        view.hideLoading();
    }
}
