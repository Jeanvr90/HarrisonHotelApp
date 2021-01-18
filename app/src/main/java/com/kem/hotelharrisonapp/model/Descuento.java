
package com.kem.hotelharrisonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Descuento {

    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("estado")
    @Expose
    private Boolean estado;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("precio")
    @Expose
    private Integer precio;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Descuento() {
    }

    /**
     * 
     * @param descripcion
     * @param estado
     * @param precio
     * @param id
     * @param nombre
     */
    public Descuento(String descripcion, Boolean estado, Integer id, String nombre, Integer precio) {
        super();
        this.descripcion = descripcion;
        this.estado = estado;
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

}
