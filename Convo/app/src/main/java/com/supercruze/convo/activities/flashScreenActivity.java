package com.supercruze.convo.activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.supercruze.convo.R;
import com.supercruze.convo.utilities.Constants;
import com.supercruze.convo.utilities.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;


public class flashScreenActivity extends AppCompatActivity {

    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceManager = new PreferenceManager(getApplicationContext());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();


        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over

            //            deciding whether the user is logged in or not so dedicated conditional activity can be called.

            Boolean check= preferenceManager.getBoolean(Constants.KEY_IS_SIGNED_IN);
            Intent i;
            if(check)
            {
                i = new Intent(flashScreenActivity.this,
                        MainActivity.class);
            }
            else{
                i = new Intent(flashScreenActivity.this, SignInActivity.class);
            }
            startActivity(i);
            finish();
        }, 5000);
    }
}

