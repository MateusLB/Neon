package com.neon.arthurabreu.neon.Login;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.neon.arthurabreu.neon.R;
import com.neon.arthurabreu.neon.Utils.DialogUtils;
import com.neon.arthurabreu.neon.Utils.Preferences;

public class LoginFragment extends Fragment implements LoginContracts.View{

    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_name) EditText _nameText;
    @BindView(R.id.btnLogin) Button _loginButton;

    LoginContracts.Presenter presenter;
    Dialog dialog;
    Preferences preferences;
    String name, email;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, view);

        presenter = new LoginPresenter(getActivity(), this);

        if ( !(TextUtils.isEmpty(_nameText.getText()) && !(TextUtils.isEmpty(_emailText.getText()) ))) {

            name = _nameText.getText().toString();
            email = _emailText.getText().toString();

            _loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.login(name, email);
                }
            });

        }else{
            Toast.makeText(getContext(), R.string.nameEmailError, Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    @Override
    public void showLoading() {
        if(dialog==null)
            dialog = DialogUtils.showProgressDialog(getContext());
        dialog.show();
    }

    @Override
    public void hideLoading() {
        if(dialog!=null)
            dialog.dismiss();
    }

    @Override
    public void showAlertError(String errorMessage) {
        DialogUtils.messageDialog(getActivity(),errorMessage,null);
    }

}
