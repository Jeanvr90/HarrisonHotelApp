package com.kem.hotelharrisonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        Objects.requireNonNull(getSupportActionBar()).hide();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                valideSession();
                finish();
            }
        }, 3000);


    }

    private void findViews() {

        preferences = getSharedPreferences("Preferencias", MODE_PRIVATE);

    }
    private void valideSession(){
        int usuario_id = preferences.getInt("id",0);

        if (usuario_id>0){
            startActivity(new Intent(this, DashboardActivity.class));
        }else {
            Intent intent=new Intent(MainActivity.this, HallActivity.class);
            startActivity(intent);
        }

    }
}