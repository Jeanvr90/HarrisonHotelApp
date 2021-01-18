package com.kem.hotelharrisonapp.retorfit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kem.hotelharrisonapp.model.Huesped;

public class ResponseRegister {


    @SerializedName("Mensaje")
    @Expose
    private String mensaje;
    @SerializedName("Huesped")
    @Expose
    private Huesped huesped;
    @SerializedName("Es Valido")
    @Expose
    private Boolean esValido;


    public ResponseRegister(String mensaje, Huesped huesped, Boolean esValido) {
        this.mensaje = mensaje;
        this.huesped = huesped;
        this.esValido = esValido;
    }

    public ResponseRegister() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Boolean getEsValido() {
        return esValido;
    }

    public void setEsValido(Boolean esValido) {
        this.esValido = esValido;
    }
}
