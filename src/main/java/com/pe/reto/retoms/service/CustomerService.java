package com.pe.reto.retoms.service;

import com.pe.reto.retoms.bean.CustomerKpiResponseBean;
import com.pe.reto.retoms.bean.CustomerRequestBean;
import com.pe.reto.retoms.bean.ListCustomerResponseBean;
import com.pe.reto.retoms.bean.ResponseBean;

public interface CustomerService {

    public ResponseBean createCustomer(CustomerRequestBean request);
    public ListCustomerResponseBean getCustomers();
    public CustomerKpiResponseBean getCustomersByKpis();

}