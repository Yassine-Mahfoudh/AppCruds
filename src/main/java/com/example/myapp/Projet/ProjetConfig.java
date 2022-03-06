package com.example.myapp.Projet;

import com.example.myapp.employee.Employee;
import com.example.myapp.employee.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ProjetConfig {

    @Bean
    CommandLineRunner commandLineRunner41(
            ProjetRepository repository){
        return args -> {
            Projet projet1 = new Projet (
                    "devops",
                    1,
                    "application web",
                    LocalDate.of(2022,3,2),
                    LocalDate.of(2022,7,28)

            );
            Projet projet2 = new Projet (
                    "mobdesing",
                    2,
                    "application mobile",
                    LocalDate.of(2022,4,21),
                    LocalDate.of(2022,8,20)

            );
            repository.saveAll(
                    List.of(projet1,projet2)
            );
        };
    }

}
