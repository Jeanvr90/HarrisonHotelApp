
package com.kem.hotelharrisonapp.retorfit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kem.hotelharrisonapp.model.Huesped;

public class ResponseProfile {

    @SerializedName("Mensaje")
    @Expose
    private String mensaje;
    @SerializedName("Huesped")
    @Expose
    private Huesped huesped;
    @SerializedName("Valido")
    @Expose
    private Boolean valido;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseProfile() {
    }

    /**
     * 
     * @param huesped
     * @param valido
     * @param mensaje
     */
    public ResponseProfile(String mensaje, Huesped huesped, Boolean valido) {
        super();
        this.mensaje = mensaje;
        this.huesped = huesped;
        this.valido = valido;
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

    public Boolean getValido() {
        return valido;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

}
