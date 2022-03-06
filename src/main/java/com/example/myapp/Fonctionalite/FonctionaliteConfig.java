package com.example.myapp.Fonctionalite;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Configuration
public class FonctionaliteConfig {

    @Bean
    CommandLineRunner commandLineRunner4(
            FonctionaliteRepository repository){
        return args -> {
            Fonctionalite f1 = new Fonctionalite (
                    "gerer profil",
                    "admin"
            );
            Fonctionalite f2 = new Fonctionalite (
                    "consulter salle",
                    "employee"
            );

            repository.saveAll(
                    List.of(f1,f2)
            );
        };
    }
}
