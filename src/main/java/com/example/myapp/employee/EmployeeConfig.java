package com.example.myapp.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            EmployeeRepository repository){
        return args -> {
            Employee yassine = new Employee (
                    "yassine",
                    "mahfoudh",
                    LocalDate.of(2000,6,25),
                    "68 darchaabene",
                    "responsableRH",
                    Boolean.FALSE
            );
            Employee houssem = new Employee (
                    "houssem",
                    "hmida",
                    LocalDate.of(1999,4,2),
                    "68 sfax",
                    "employee",
                    Boolean.TRUE
            );
            repository.saveAll(
                    List.of(yassine,houssem)
            );
        };
    }

}
