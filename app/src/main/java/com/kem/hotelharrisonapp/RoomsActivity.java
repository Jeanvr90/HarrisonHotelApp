package com.kem.hotelharrisonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kem.hotelharrisonapp.retorfit.HotelHarrisonClient;
import com.kem.hotelharrisonapp.retorfit.HotelHarrisonService;
import com.kem.hotelharrisonapp.retorfit.response.ResponseRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView notFound;
    List<ResponseRoom>rooms=new ArrayList<>();
    RoomAdapter roomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        Objects.requireNonNull(getSupportActionBar()).hide();

        recyclerView = findViewById(R.id.rv_rooms);
        recyclerView.setHasFixedSize(true);
    

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        roomAdapter=new RoomAdapter(this,rooms);

        recyclerView.setAdapter(roomAdapter);
        loadRoomFromRetrofit();
    }

    private void loadRoomFromRetrofit(){

        HotelHarrisonClient.getInstance().getHotelHarrisonService().doRooms().enqueue(new Callback<List<ResponseRoom>>() {
            @Override
            public void onResponse(Call<List<ResponseRoom>> call, Response<List<ResponseRoom>> response) {

                if (response.isSuccessful()&&response.body()!=null){
                    rooms.clear();
                    rooms.addAll(response.body());
                    roomAdapter.notifyDataSetChanged();
                }else{

                }
            }

            @Override
            public void onFailure(Call<List<ResponseRoom>> call, Throwable t) {

            }
        });
    }
}