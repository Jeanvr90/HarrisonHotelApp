
package com.kem.hotelharrisonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Huesped {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellido")
    @Expose
    private String apellido;
    @SerializedName("documento")
    @Expose
    private String documento;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("estado")
    @Expose
    private Boolean estado;
    @SerializedName("tipoDocumento")
    @Expose
    private TipoDocumento tipoDocumento;
    @SerializedName("tipoHuesped")
    @Expose
    private TipoHuesped tipoHuesped;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Huesped() {
    }

    /**
     * 
     * @param tipoHuesped
     * @param tipoDocumento
     * @param estado
     * @param apellido
     * @param correo
     * @param documento
     * @param id
     * @param telefono
     * @param nombre
     */
    public Huesped(Integer id, String nombre, String apellido, String documento, String correo, String telefono, Boolean estado, TipoDocumento tipoDocumento, TipoHuesped tipoHuesped) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
        this.tipoDocumento = tipoDocumento;
        this.tipoHuesped = tipoHuesped;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public TipoHuesped getTipoHuesped() {
        return tipoHuesped;
    }

    public void setTipoHuesped(TipoHuesped tipoHuesped) {
        this.tipoHuesped = tipoHuesped;
    }

}
