package com.kem.hotelharrisonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Estacionamiento {
    @SerializedName("id")
    @Expose
    Long id;
    @SerializedName("nombre")
    @Expose
    String nombre;
}
