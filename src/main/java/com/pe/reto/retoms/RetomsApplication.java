package com.pe.reto.retoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RetomsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetomsApplication.class, args);
    }

}
