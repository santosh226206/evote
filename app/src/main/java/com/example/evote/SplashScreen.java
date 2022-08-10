package com.example.evote;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.evote.activities.HomeActivity;
import com.example.evote.activities.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    public static final String PREFERENCES="prefKey";
    SharedPreferences sharedPreferences;
    public static final String IsLogIn="isLogin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences=getApplicationContext().getSharedPreferences(PREFERENCES,MODE_PRIVATE);
        boolean bool=sharedPreferences.getBoolean(IsLogIn,false);
        new Handler().postDelayed(()->{
            if(bool){
                startActivity(new Intent(SplashScreen.this, HomeActivity.class));
                finish();
            }
            else{
                startActivity(new Intent(SplashScreen.this,LoginActivity.class));
                finish();
            }
        },3000);
    }
}