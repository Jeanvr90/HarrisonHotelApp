package com.kem.hotelharrisonapp.ui.reserve;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kem.hotelharrisonapp.model.Reserva;
import com.kem.hotelharrisonapp.retorfit.HotelHarrisonClient;
import com.kem.hotelharrisonapp.retorfit.response.ReservaByUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReserveViewModel extends ViewModel {
    MutableLiveData<List<Reserva>> reservaMutable = new MutableLiveData<>();
    MutableLiveData<String> msgError = new MutableLiveData<>();


    public void getReservaHistorial(int id) {


        HotelHarrisonClient.getInstance().getHotelHarrisonService().getHistorialById(id).enqueue(new Callback<List<Reserva>>() {
            @Override
            public void onResponse(Call<List<Reserva>> call, Response<List<Reserva>> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body().get(0).getPrecioTotal());
                    reservaMutable.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Reserva>> call, Throwable t) {
                System.out.println(t.getCause() + t.getLocalizedMessage() + t.getMessage());
            }
        });
    }

}