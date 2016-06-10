package com.danirg10000gmail.firebasetemplate.ui.ui.createAccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.danirg10000gmail.firebasetemplate.R;
import com.danirg10000gmail.firebasetemplate.ui.ui.login.LoginActivity;

public class CreateAccountFragment extends Fragment {

    private EditText mMail, mPassword, mVerifyPassword, mUserName;
    private Button mCreateAccount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_account, container, false);
        initWidgets(v);
        return v;
    }


    private void initWidgets(View v) {
        initMail(v);
        initPassword(v);
        initVerifyPassword(v);
        initUserName(v);
        initCreateAccountButton(v);

    }

    private void initMail(View v) {
        mMail = (EditText) v.findViewById(R.id.fragment_create_account_mail);
    }

    private void initPassword(View v) {
        mPassword = (EditText) v.findViewById(R.id.fragment_create_account_password);
    }

    private void initVerifyPassword(View v) {
        mVerifyPassword = (EditText) v.findViewById(R.id.fragment_create_account_verify_password);
    }

    private void initUserName(View v) {
        mUserName = (EditText) v.findViewById(R.id.fragment_create_account_user_name);
    }

    private void initCreateAccountButton(View v) {
        mCreateAccount = (Button) v.findViewById(R.id.fragment_create_account_button);
        mCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = CreateAccountFragment.this.getActivity();
                String mail = mMail.getText().toString();
                String password = mPassword.getText().toString();
                String verifyPassword = mVerifyPassword.getText().toString();
                if (checkPassword(password,verifyPassword)) {

                    Intent intent = LoginActivity.newIntent(activity, mail, password);
                    activity.setResult(Activity.RESULT_OK, intent);
                    activity.finish();
                } else {
                    Toast.makeText(activity,R.string.create_account_password_verification_failed_,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

private boolean checkPassword(String password, String confirmPassword){
    return password.equals(confirmPassword);
}


}
