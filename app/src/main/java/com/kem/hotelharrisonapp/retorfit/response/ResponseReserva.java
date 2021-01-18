package com.kem.hotelharrisonapp.retorfit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kem.hotelharrisonapp.model.Habitacion;
import com.kem.hotelharrisonapp.model.Huesped;

import java.time.LocalTime;

public class ResponseReserva {
    @SerializedName("fechaInicio")
    @Expose
    private String fechaInicio;
    @SerializedName("fechaFinal")
    @Expose
    private String fechaFinal;
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

    public ResponseReserva(String fechaInicio, String fechaFinal, Habitacion habitacion, Huesped huesped, String placa, int total) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.placa = placa;
        this.total = total;
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
