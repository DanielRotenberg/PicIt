package com.danirg10000gmail.firebasetemplate.ui.ui.createAccount;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;

import com.danirg10000gmail.firebasetemplate.R;
import com.danirg10000gmail.firebasetemplate.ui.BaseActivity;

public class CreateAccountActivity extends BaseActivity {
    @Override
    protected Fragment getFragment() {
        return new CreateAccountFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);
    }

    public static Intent newIntent (Context context){
        Intent intent = new Intent(context,CreateAccountActivity.class);
        return intent;
    }


}
