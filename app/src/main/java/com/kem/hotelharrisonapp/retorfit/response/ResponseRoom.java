
package com.kem.hotelharrisonapp.retorfit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kem.hotelharrisonapp.model.Nivel;
import com.kem.hotelharrisonapp.model.TipoHabitacion;

public class ResponseRoom {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("imagen")
    @Expose
    private String imagen;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("nivel")
    @Expose
    private Nivel nivel;
    @SerializedName("tipoHabitacion")
    @Expose
    private TipoHabitacion tipoHabitacion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseRoom() {
    }

    /**
     * 
     * @param descripcion
     * @param estado
     * @param imagen
     * @param id
     * @param tipoHabitacion
     * @param nombre
     * @param nivel
     */
    public ResponseRoom(Integer id, String nombre, String descripcion, String imagen, String estado, Nivel nivel, TipoHabitacion tipoHabitacion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.estado = estado;
        this.nivel = nivel;
        this.tipoHabitacion = tipoHabitacion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

}
