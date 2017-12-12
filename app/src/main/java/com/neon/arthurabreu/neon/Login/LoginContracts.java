package com.neon.arthurabreu.neon.Login;

import android.content.Context;

/**
 * Created by af2g on 12/12/2017.
 */

public class LoginContracts {

    public interface View{
        void showLoading();
        void hideLoading();
        void showAlertError(String errorMessage);
    }

    public interface Presenter{
        void sendMoney();
        void events();
        void onSendSuccess();
        void onSendFailed();
        void onEventSuccess();
        void onEventFailed();
        boolean validate();
    }

    public interface InteractorInput{
        void fetchContacts(Context context);

    }

    public interface InteractorOutput{
        void showLoading();
        void hideLoading();
    }
}
