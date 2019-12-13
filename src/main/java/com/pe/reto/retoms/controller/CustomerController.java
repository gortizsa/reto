package com.pe.reto.retoms.controller;

import com.pe.reto.retoms.bean.CustomerKpiResponseBean;
import com.pe.reto.retoms.bean.CustomerRequestBean;
import com.pe.reto.retoms.bean.ListCustomerResponseBean;
import com.pe.reto.retoms.bean.ResponseBean;
import com.pe.reto.retoms.config.ApplicationProperties;
import com.pe.reto.retoms.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Reto microservicio")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ApplicationProperties properties;

    @PostMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registra Customer", notes = "Registra Customer en AWS RDS")
    public ResponseBean createCustomer(@RequestBody CustomerRequestBean customerBeanRequest) {
        ResponseBean response = null;
        try {
            response = customerService.createCustomer(customerBeanRequest);
        } catch (Exception e) {
            response = new ResponseBean();
            response.setCod(Integer.parseInt(properties.getCdgError()));
            response.setMensaje(properties.getMsjError() + "\n" + e.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recupera todos los Customer", notes = "Recupera todos los customer de AWS RDS")
    public ListCustomerResponseBean getCustomer() {
        ListCustomerResponseBean response = null;
        try {
            response = customerService.getCustomers();
        } catch (Exception e) {
            response = new ListCustomerResponseBean();
            response.setCod(Integer.parseInt(properties.getCdgError()));
            response.setMensaje(properties.getMsjError() + "\n" + e.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/customers/kpis", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Genera KPIs", notes = "Media de edades y desviancion estandar")
    public CustomerKpiResponseBean getCustomerByKpis() {
        CustomerKpiResponseBean response = null;
        try {
            response = customerService.getCustomersByKpis();
        } catch (Exception e) {
            response = new CustomerKpiResponseBean();
            response.setCod(Integer.parseInt(properties.getCdgError()));
            response.setMensaje(properties.getMsjError() + "\n" + e.getMessage());
        }
        return response;
    }

}