package com.pe.reto.retoms.service.impl;

import com.pe.reto.retoms.bean.*;
import com.pe.reto.retoms.config.ApplicationProperties;
import com.pe.reto.retoms.model.Customer;
import com.pe.reto.retoms.repository.CustomerRepository;
import com.pe.reto.retoms.service.CustomerService;
import com.pe.reto.retoms.util.DesvStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ApplicationProperties properties;

    @Override
    public ResponseBean createCustomer(CustomerRequestBean request) {
        ResponseBean response = new ResponseBean();
        try {
            customerRepository.save(getCustomer(request));
            response.setCod(Integer.parseInt(properties.getCdgExito()));
            response.setMensaje(properties.getMsjExito());
        } catch (Exception e) {
            response.setCod(Integer.parseInt(properties.getCdgError()));
            response.setMensaje(properties.getMsjError() + "\n" + e.getMessage());
        }
        return response;
    }

    @Override
    public ListCustomerResponseBean getCustomers() {
        ListCustomerResponseBean response = new ListCustomerResponseBean();
        try {
            List<CustomerResponseBean> customers = new ArrayList<>();
            System.out.println(customerRepository.edades());
            customerRepository.findAll().stream().forEach(customer -> {
                CustomerResponseBean bean = new CustomerResponseBean();
                bean.setNombre(customer.getNombre());
                bean.setApellido(customer.getApellido());
                bean.setEdad(customer.getEdad());
                bean.setFechaNac(customer.getNacimiento());
                bean.setFechaMortalidad(getMortalidad(customer.getNacimiento()));
                customers.add(bean);
            });
            response.setCustomers(customers);
            response.setCod(Integer.parseInt(properties.getCdgExito()));
            response.setMensaje(properties.getMsjExito());
        } catch (Exception e) {
            response.setCod(Integer.parseInt(properties.getCdgError()));
            response.setMensaje(properties.getMsjError() + "\n" + e.getMessage());
        }
        return response;
    }

    @Override
    public CustomerKpiResponseBean getCustomersByKpis() {
        CustomerKpiResponseBean response = new CustomerKpiResponseBean();
        try {
            response.setPromEdadCust(getAverage());
            response.setDesvEst(DesvStandard.getDesv(getAges()));
            response.setCod(Integer.parseInt(properties.getCdgExito()));
            response.setMensaje(properties.getMsjExito());
        } catch (Exception e) {
            response.setCod(Integer.parseInt(properties.getCdgError()));
            response.setMensaje(properties.getMsjError() + "\n" + e.getMessage());
        }
        return response;
    }

    private Customer getCustomer(CustomerRequestBean bean){
        Customer customer = new Customer();
        customer.setNombre(bean.getNombre());
        customer.setApellido(bean.getApellido());
        customer.setEdad(bean.getEdad());
        customer.setNacimiento(bean.getFechaNac());
        return customer;
    }

    private int getAverage() {
        return customerRepository.avg();
    }

    private List<Double> getAges() {
        return customerRepository.edades();
    }

    private Date getMortalidad(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, new Random().nextInt(20) + 1);
        return calendar.getTime();
    }

}