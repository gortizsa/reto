package com.pe.reto.retoms.bean;

import java.util.List;

public class ListCustomerResponseBean extends ResponseBean{

    private List<CustomerResponseBean> customers;

    public List<CustomerResponseBean> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerResponseBean> customers) {
        this.customers = customers;
    }

}