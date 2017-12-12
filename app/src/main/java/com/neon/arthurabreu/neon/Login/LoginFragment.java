package com.neon.arthurabreu.neon.Login;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.neon.arthurabreu.neon.R;
import com.pnikosis.materialishprogress.ProgressWheel;

public class LoginFragment extends Fragment implements LoginContracts.View{

    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_name) EditText _nameText;
    @BindView(R.id.btn_sendMoney) Button _sendMoneyButton;
    @BindView(R.id.btn_Events) Button _eventsButton;

    LoginContracts.Presenter presenter;

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
                presenter.sendMoney();
            }
        });

        _eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.events();
            }
        });

        return view;
    }

    @Override
    public void showLoading() {
        ProgressWheel wheel = new ProgressWheel(getContext());
        wheel.setBarColor(Color.WHITE);
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showAlertError(String errorMessage) {

    }
}
