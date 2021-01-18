package com.kem.hotelharrisonapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kem.hotelharrisonapp.commons.SharedPreferencesConfig;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;

public class DashboardActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String name = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        init();

        name = preferences.getString("nombre", null);

        System.out.println("este es el valor en el dashboaarActivity + " + name);

        this.setTitle(name);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_account, R.id.navigation_reserve,
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_gps)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        Objects.requireNonNull(getSupportActionBar()).hide();



    }


    private void init() {

        preferences = getSharedPreferences("Preferencias", MODE_PRIVATE);
    }


}