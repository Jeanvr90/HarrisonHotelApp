package com.kem.hotelharrisonapp.ui.FormReserva;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.kem.hotelharrisonapp.model.Habitacion;
import com.kem.hotelharrisonapp.model.Huesped;
import com.kem.hotelharrisonapp.model.Reserva;
import com.kem.hotelharrisonapp.retorfit.HotelHarrisonClient;
import com.kem.hotelharrisonapp.retorfit.request.RequestReserva;
import com.kem.hotelharrisonapp.retorfit.response.ResponseReserva;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormReservaViewModel extends AndroidViewModel {

    public FormReservaViewModel(@NonNull Application application) {
        super(application);
    }

    public void registerReserva(int huesped, int habitacion, String fecha_inicio, String fecha_final, String placa, int total) {


        Huesped h = new Huesped();
        Habitacion hab = new Habitacion();
        hab.setId(habitacion);
        h.setId(huesped);

        Reserva reserva = new Reserva();
        reserva.setFechaInicio(fecha_inicio.concat("T13:00"));
        reserva.setHuesped(h);
        reserva.setHabitacion(hab);
        reserva.setFechaFinal(fecha_final.concat("T13:00"));
        reserva.setPlacaVehiculo(placa);
        reserva.setPrecioTotal((double) total);

        Call<Reserva> responseReservaCall = HotelHarrisonClient.getInstance().getHotelHarrisonService().doReserva(reserva);

        responseReservaCall.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Call<Reserva> call, Response<Reserva> response) {
                if (response.isSuccessful()) {
                    System.out.println("Exito");
                } else {
                    System.out.println("codigo " + response.code());
                    ;
                }
            }

            @Override
            public void onFailure(Call<Reserva> call, Throwable t) {

            }
        });
    }
}
