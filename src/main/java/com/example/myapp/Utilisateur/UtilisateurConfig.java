package com.example.myapp.Utilisateur;


import com.example.myapp.employee.Employee;
import com.example.myapp.employee.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration

public class UtilisateurConfig {
    @Bean
    CommandLineRunner commandLineRunner2(
            UtilisateurRepository utilisateurRepository,
    EmployeeRepository employeeRepository){
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
            employeeRepository.saveAll(
                    List.of(yassine,houssem)
            );

            Utilisateur salah = new Utilisateur (
                    "mohamed",
                    "mdp1",
                    "user1@gmail.com"
            );
            Utilisateur oussama = new Utilisateur (
                    "user",
                    "mdp2",
                    "user2@gmail.com"
            );
            utilisateurRepository.saveAll(
                    List.of(salah,oussama)
            );

        };
    }

}
