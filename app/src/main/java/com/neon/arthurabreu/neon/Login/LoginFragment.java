package com.neon.arthurabreu.neon.Login;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.neon.arthurabreu.neon.R;
import com.neon.arthurabreu.neon.Utils.DialogUtils;

public class LoginFragment extends Fragment implements LoginContracts.View{

    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_name) EditText _nameText;
    @BindView(R.id.btn_sendMoney) Button _sendMoneyButton;
    @BindView(R.id.btn_Events) Button _eventsButton;

    LoginContracts.Presenter presenter;
    Dialog dialog;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, view);

        presenter = new LoginPresenter(getActivity(), this);

        _emailText.setText("stormborn@motherofdragons.com");
        _nameText.setText("Daenerys");
        _emailText.setKeyListener(null);
        _nameText.setKeyListener(null);

        _sendMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getContacts();
                //_sendMoneyButton.setEnabled(true);
            }
        });

        _eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.gotToEvents();
            }
        });

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
