package com.pe.reto.retoms.bean;

import com.pe.reto.retoms.util.Constantes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CustomerRequestBean {

    @NotBlank(message = Constantes.MSJ_NOT_BLANK)
    private String nombre;

    @NotBlank(message = Constantes.MSJ_NOT_BLANK)
    private String apellido;

    @NotNull(message = Constantes.MSJ_NOT_BLANK)
    private int edad;

    @NotNull(message = Constantes.MSJ_NOT_BLANK)
    private Date fechaNac;

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

}