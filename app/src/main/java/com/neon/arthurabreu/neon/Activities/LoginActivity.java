package com.neon.arthurabreu.neon.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.neon.arthurabreu.neon.GenericActivity;
import com.neon.arthurabreu.neon.Login.LoginFragment;
import com.neon.arthurabreu.neon.R;

public class LoginActivity extends AppCompatActivity {
//    private static final String TAG = "LoginActivity";
//    private static final int REQUEST_SIGNUP = 0;
//
//    @BindView(R.id.input_email) EditText _emailText;
//    @BindView(R.id.input_name) EditText _nameText;
//    @BindView(R.id.btn_sendMoney) Button _sendMoneyButton;
//    @BindView(R.id.btn_Events) Button _eventsButton;


    //===================================================
    //ONCREATE
    //===================================================

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_fragment);


        LoginFragment loginFragment = new LoginFragment();
        GenericActivity genericActivity = new GenericActivity();
        genericActivity.selectFragment(loginFragment);



//        ButterKnife.bind(this);
//
//        _emailText.setText("stormborn@motherofdragons.com");
//        _nameText.setText("Daenerys");
//
//        _emailText.setKeyListener(null);
//        _nameText.setKeyListener(null);

//        _sendMoneyButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                sendMoney();
//            }
//        });
//
//        _eventsButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                eventHistory();
//            }
//        });
    }

//    public void sendMoney() {
//        Log.d(TAG, "SendMoney");
//
//        if (!validate()) {
//            onSendFailed();
//            return;
//        }
//
//        _sendMoneyButton.setEnabled(false);
//
//        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
//                R.style.AppTheme_Dark_Dialog);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Authenticating...");
//        progressDialog.show();
//
//        // TODO: Implement your own authentication logic here.
//
//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//                        // On complete call either goToSendMoney or onSendFailed
//                        onSendSuccess();
//                        // onSendFailed();
//                        progressDialog.dismiss();
//                    }
//                }, 3000);
//    }
//
//    public void eventHistory() {
//        Log.d(TAG, "EventHistory");
//
//        if (!validate()) {
//            onEventFailed();
//            return;
//        }
//
//        _eventsButton.setEnabled(false);
//
//        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
//                R.style.AppTheme_Dark_Dialog);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Authenticating...");
//        progressDialog.show();
//
//        // TODO: Implement your own authentication logic here.
//
//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//                        // On complete call either goToSendMoney or onSendFailed
//                        onEventSuccess();
//                        // onSendFailed();
//                        progressDialog.dismiss();
//                    }
//                }, 3000);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_SIGNUP) {
//            if (resultCode == RESULT_OK) {
//
//                // TODO: Implement successful signup logic here
//                // By default we just finish the Activity and log them in automatically
//                this.finish();
//            }
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//        // disable going back to the MainActivity
//        moveTaskToBack(true);
//    }
//
//    public void onSendSuccess() {
//
//        //Jump to the next activity
//        Intent intent = new Intent(getApplicationContext(), ContactsActivity.class);
//        startActivity(intent);
//
//        _sendMoneyButton.setEnabled(true);
//        finish();
//    }
//
//    public void onSendFailed() {
//        Toast.makeText(getBaseContext(), "Operation failed", Toast.LENGTH_LONG).show();
//
//        _sendMoneyButton.setEnabled(true);
//    }
//
//    public void onEventSuccess() {
//
//        //Jump to the next activity
//        Intent intent = new Intent(getApplicationContext(), GetTransfersActivity.class);
//        startActivity(intent);
//
//        _eventsButton.setEnabled(true);
//        finish();
//    }
//
//    public void onEventFailed() {
//        Toast.makeText(getBaseContext(), "Operation failed", Toast.LENGTH_LONG).show();
//
//        _eventsButton.setEnabled(true);
//    }
//
//    public boolean validate() {
//        boolean valid = true;
//
//        String email = _emailText.getText().toString();
//        String name = _nameText.getText().toString();
//
//        if (TextUtils.isEmpty(email) || !(email.equals("stormborn@motherofdragons.com"))) {
//            _emailText.setError("Not stormborn or mother of dragons");
//            valid = false;
//        } else {
//            _emailText.setError(null);
//        }
//
//        if (TextUtils.isEmpty(name) || !(name.equals("Daenerys"))) {
//            _nameText.setError("Bend the knee");
//            valid = false;
//        } else {
//            _nameText.setError(null);
//        }
//
//        return valid;
//    }
}
