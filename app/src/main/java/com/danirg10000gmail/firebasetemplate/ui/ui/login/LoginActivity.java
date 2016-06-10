package com.danirg10000gmail.firebasetemplate.ui.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.danirg10000gmail.firebasetemplate.R;
import com.danirg10000gmail.firebasetemplate.ui.BaseActivity;

public class LoginActivity extends BaseActivity {

    private static final String MAIL_EXTRA = "mailExtra";
    private static final String PASSWORD_EXTRA = "passwordExtra";

    public static Intent newIntent(Context context, String mail, String password){
        Intent intent = new Intent(context,LoginActivity.class);
        intent.putExtra(MAIL_EXTRA,mail);
        intent.putExtra(PASSWORD_EXTRA,password);
        return intent;
    }


    @Override
    protected Fragment getFragment() {
        return new LoginFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);
    }

    public static String getMailExtra (Intent data){
        return data.getStringExtra(MAIL_EXTRA);
    }

    public static String getPasswordExtra(Intent data){
        return data.getStringExtra(PASSWORD_EXTRA);
    }
}