package com.kem.hotelharrisonapp.retorfit;

import com.kem.hotelharrisonapp.model.Habitacion;
import com.kem.hotelharrisonapp.model.Huesped;
import com.kem.hotelharrisonapp.model.Reserva;
import com.kem.hotelharrisonapp.retorfit.request.RequestFilterRooms;
import com.kem.hotelharrisonapp.retorfit.request.RequestLogin;
import com.kem.hotelharrisonapp.retorfit.request.RequestRegister;
import com.kem.hotelharrisonapp.retorfit.request.RequestReserva;
import com.kem.hotelharrisonapp.retorfit.response.ReservaByUser;
import com.kem.hotelharrisonapp.retorfit.response.ResponseProfile;
import com.kem.hotelharrisonapp.retorfit.response.ResponseReserva;
import com.kem.hotelharrisonapp.retorfit.response.ResponseRoom;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HotelHarrisonService {
    @POST("huespedes/login")
    Call<ResponseProfile> doLogin(@Body RequestLogin requestLogin);

    @POST("huespedes")
    Call<ResponseProfile> doRegister(@Body RequestRegister requestRegister);

    @GET("habitaciones")
    Call<List<ResponseRoom>> doRooms();


    @POST("huespedes/login")
    Call<ResponseProfile> getProfile();


    @GET("huespedes/{id}")
    Call<Huesped> getHuespedByid(@Path("id") int id);

    @GET("habitaciones/{id}")
    Call<Habitacion> getHabitacionByid(@Path("id") int id);


    @POST("reservas/find-dateTime")
    Call<List<ResponseRoom>> doFilterByRooms(@Body RequestFilterRooms filterRooms);


    //Reserva
    @POST("reservas")
    Call<Reserva> doReserva(@Body Reserva reserva);

    @GET("reservas/huesped/{id}")
    Call<List<Reserva>> getHistorialById(@Path("id") int id);

}
