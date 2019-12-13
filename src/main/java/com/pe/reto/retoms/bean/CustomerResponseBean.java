package com.pe.reto.retoms.bean;

import java.util.Date;
import java.util.List;

public class CustomerResponseBean extends CustomerRequestBean {

    private Date fechaMortalidad;

    public Date getFechaMortalidad() {
        return fechaMortalidad;
    }

    public void setFechaMortalidad(Date fechaMortalidad) {
        this.fechaMortalidad = fechaMortalidad;
    }

}