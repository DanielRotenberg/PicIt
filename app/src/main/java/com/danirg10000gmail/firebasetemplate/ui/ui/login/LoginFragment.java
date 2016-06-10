package com.danirg10000gmail.firebasetemplate.ui.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.danirg10000gmail.firebasetemplate.R;
import com.danirg10000gmail.firebasetemplate.ui.ui.createAccount.CreateAccountActivity;


public class LoginFragment extends Fragment {

    public static final String TAG_LOG = LoginFragment.class.getSimpleName();
    private static final int REQUEST_CODE_CREATE_ACCOUNT = 0;

    private EditText mMail, mPassword;
    private Button mGoTOCreateAccount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login,container,false);
        initWidgets(v);
        return v;
    }


    private void initWidgets(View v){
        initMail(v);
        initPassword(v);
        initGoToCreateAccountButton(v);
    }

    private void initMail(View v){
        mMail = (EditText) v.findViewById(R.id.fragment_login_mail);
    }
    private void initPassword (View v){
        mPassword = (EditText)v.findViewById(R.id.fragment_login_password);

    }

    private void initGoToCreateAccountButton(View v){
        mGoTOCreateAccount = (Button)v.findViewById(R.id.fragment_login_button_goto_create_account);
        mGoTOCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = CreateAccountActivity.newIntent(getActivity());
                startActivityForResult(intent,REQUEST_CODE_CREATE_ACCOUNT);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == getActivity().RESULT_OK && data != null){

            if (requestCode == REQUEST_CODE_CREATE_ACCOUNT){

                String mail = LoginActivity.getMailExtra(data);
                String password = LoginActivity.getPasswordExtra(data);
                Log.d(TAG_LOG,mail+" "+password );
                mMail.setText(mail);
                mPassword.setText(password);
            }
        }
    }
}
