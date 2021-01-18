package com.kem.hotelharrisonapp.retorfit.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kem.hotelharrisonapp.model.Habitacion;
import com.kem.hotelharrisonapp.model.Huesped;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class RequestReserva {

    @SerializedName("fechaFinal")
    @Expose
    private String fechaFinal;
    @SerializedName("fechaInicio")
    @Expose
    private String fechaInicio;
    @SerializedName("habitacion")
    @Expose
    private Habitacion habitacion;
    @SerializedName("huesped")
    @Expose
    private Huesped huesped;
    @SerializedName("placaVehiculo")
    @Expose
    private String placa;
    @SerializedName("precioTotal")
    @Expose
    private int total;

   


    public RequestReserva() {
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
