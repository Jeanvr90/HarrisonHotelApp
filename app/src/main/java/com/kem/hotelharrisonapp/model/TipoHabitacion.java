package com.kem.hotelharrisonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TipoHabitacion {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("nroCamas")
    @Expose
    private Integer nroCamas;
    @SerializedName("precio")
    @Expose
    private Integer precio;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TipoHabitacion() {
    }

    /**
     * 
     * @param precio
     * @param nroCamas
     * @param id
     * @param nombre
     */
    public TipoHabitacion(Integer id, String nombre, Integer nroCamas, Integer precio) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.nroCamas = nroCamas;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNroCamas() {
        return nroCamas;
    }

    public void setNroCamas(Integer nroCamas) {
        this.nroCamas = nroCamas;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

}
