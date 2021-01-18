package com.kem.hotelharrisonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Reserva {


    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("fechaInicio")
    @Expose
    private String fechaInicio;

    @SerializedName("fechaFinal")
    @Expose
    private String fechaFinal;

    @SerializedName("diaInicio")
    @Expose
    private String diaInicio;
    @SerializedName("diaFinal")
    @Expose
    private String diaFinal;
    @SerializedName("placaVehiculo")
    @Expose
    private String placaVehiculo;

    @SerializedName("creadoEn")
    @Expose
    private String creadoEn;

    @SerializedName("igv")
    @Expose
    private Double igv;

    @SerializedName("descuento")
    @Expose
    private Double descuento;

    @SerializedName("precioTotal")
    @Expose
    private Double precioTotal;

    @SerializedName("estado")
    @Expose
    private String estado;

    @SerializedName("usuario")
    @Expose
    private Usuario usuario;

    @SerializedName("huesped")
    @Expose
    private Huesped huesped;

    @SerializedName("habitacion")
    @Expose
    private Habitacion habitacion;

    @SerializedName("estacionamiento")
    @Expose
    private Estacionamiento estacionamiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(String diaInicio) {
        this.diaInicio = diaInicio;
    }

    public String getDiaFinal() {
        return diaFinal;
    }

    public void setDiaFinal(String diaFinal) {
        this.diaFinal = diaFinal;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(String creadoEn) {
        this.creadoEn = creadoEn;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Estacionamiento getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(Estacionamiento estacionamiento) {
        this.estacionamiento = estacionamiento;
    }
}
