package com.pe.reto.retoms.repository;

import com.pe.reto.retoms.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT avg(edad) FROM Customer")
    public int avg();

    @Query(value = "SELECT edad FROM Customer")
    public List<Double> edades();

}