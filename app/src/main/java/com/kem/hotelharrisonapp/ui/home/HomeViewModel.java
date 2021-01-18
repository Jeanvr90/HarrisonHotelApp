package com.kem.hotelharrisonapp.ui.home;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kem.hotelharrisonapp.model.Habitacion;
import com.kem.hotelharrisonapp.retorfit.HotelHarrisonClient;
import com.kem.hotelharrisonapp.retorfit.request.RequestFilterRooms;
import com.kem.hotelharrisonapp.retorfit.response.ResponseRoom;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends AndroidViewModel {


    public MutableLiveData<List<ResponseRoom>> roomMutable = new MutableLiveData<>();


    public HomeViewModel(@NonNull Application application) {
        super(application);
    }



    public void getRoomsByDate(String fecha_inicio, String f_final) {
        RequestFilterRooms request = new RequestFilterRooms();
        request.setFinish(f_final);
        request.setStart(fecha_inicio);
        HotelHarrisonClient.getInstance().getHotelHarrisonService().doFilterByRooms(request).enqueue(new Callback<List<ResponseRoom>>() {
            @Override
            public void onResponse(Call<List<ResponseRoom>> call, Response<List<ResponseRoom>> response) {
                if (response.isSuccessful()){
                    roomMutable.setValue(response.body());
                }else {
                    System.out.println("codigo de error"+ response.code());
                }
            }
            @Override
            public void onFailure(Call<List<ResponseRoom>> call, Throwable t) {
                System.out.println("Error"+ t.getLocalizedMessage() );
            }
        });

    }
}