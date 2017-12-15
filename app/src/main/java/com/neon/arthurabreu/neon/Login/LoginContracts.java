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
        void login(String name, String email);
    }

    public interface InteractorInput{
        void login(String name, String email);
    }

    public interface InteractorOutput{
        void showLoading();
        void hideLoading();
        void showAlertError(String errorMessage);
        void apiError(String s);
    }
}
