package com.pe.reto.retoms.bean;

public class CustomerKpiResponseBean extends ResponseBean{

    private int promEdadCust;
    private double desvEst;

    public int getPromEdadCust() {
        return promEdadCust;
    }

    public void setPromEdadCust(int promEdadCust) {
        this.promEdadCust = promEdadCust;
    }

    public double getDesvEst() {
        return desvEst;
    }

    public void setDesvEst(double desvEst) {
        this.desvEst = desvEst;
    }

}
