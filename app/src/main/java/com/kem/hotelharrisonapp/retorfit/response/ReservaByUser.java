package com.kem.hotelharrisonapp.retorfit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kem.hotelharrisonapp.model.Habitacion;
import com.kem.hotelharrisonapp.model.Huesped;
import com.kem.hotelharrisonapp.model.Reserva;

import java.util.List;

public class ReservaByUser {
    @SerializedName("Huesped")
    @Expose
    private Reserva reserva;

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
