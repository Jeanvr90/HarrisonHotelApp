
package com.kem.hotelharrisonapp.retorfit.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kem.hotelharrisonapp.model.TipoDocumento;
import com.kem.hotelharrisonapp.model.TipoHuesped;

public class RequestRegister {

    @SerializedName("documento")
    @Expose
    private String documento;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellido")
    @Expose
    private String apellido;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("password")
    @Expose
    private String password;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestRegister() {
    }

    public RequestRegister(String documento, String nombre, String apellido, String correo, String password) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
    }

    /**
     *

     */


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
