package com.pe.reto.retoms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

    @Value("${mensaje.exito}")
    private String msjExito;

    @Value("${mensaje.error}")
    private String msjError;

    @Value("${codigo.exito}")
    private String cdgExito;

    @Value("${codigo.error}")
    private String cdgError;

    public String getMsjExito() {
        return msjExito;
    }

    public void setMsjExito(String msjExito) {
        this.msjExito = msjExito;
    }

    public String getMsjError() {
        return msjError;
    }

    public void setMsjError(String msjError) {
        this.msjError = msjError;
    }

    public String getCdgExito() {
        return cdgExito;
    }

    public void setCdgExito(String cdgExito) {
        this.cdgExito = cdgExito;
    }

    public String getCdgError() {
        return cdgError;
    }

    public void setCdgError(String cdgError) {
        this.cdgError = cdgError;
    }

}