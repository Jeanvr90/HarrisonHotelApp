package com.kem.hotelharrisonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class HallActivity extends AppCompatActivity  {

    ImageView imageView;
    private enum BTEvent {
        LOGIN, MAP, ROOMS
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);
        imageView = findViewById(R.id.img_map);
        Glide.with(this).load("https://mk0analyticsindf35n9.kinstacdn.com/wp-content/uploads/2019/04/d7ae0170d3d5ffcbaa7f02fdda387a3b.gif").into(imageView);
        Objects.requireNonNull(getSupportActionBar()).hide();


        findViews();
    }



    private void findViews() {
        findViewById(R.id.btn_login_login).setOnClickListener(view -> buttonLoginEvent());
       findViewById(R.id.btn_rooms).setOnClickListener(view -> buttonRoomsEvent());
        findViewById(R.id.btn_map).setOnClickListener(v -> buttonMap());
//        findViewById(R.id.btEpisodes).setOnClickListener(view -> buttonEvent(BTEvent.EPISODES));

    }

    private void buttonMap() {
        Intent  intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    private void buttonLoginEvent() {
        Intent  intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    private void buttonRoomsEvent(){
        Intent  intent = new Intent(this, RoomsActivity.class);
        startActivity(intent);
    }




}