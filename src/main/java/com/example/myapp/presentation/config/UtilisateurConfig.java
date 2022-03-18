package com.example.myapp.presentation.config;


import com.example.myapp.persistence.model.Utilisateur;
import com.example.myapp.persistence.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class UtilisateurConfig {

    @Bean
    CommandLineRunner commandLineRunner16(
            UtilisateurRepository repository){
        return args -> {
            Utilisateur user1 = new Utilisateur(
                    "hous",
                    "00000000",
                    "houssem@gmail.com"
            );
            Utilisateur user2 = new Utilisateur(
                    "yass",
                    "11223344",
                    "yassine@gmail.com"
            );

            repository.saveAll(
                    List.of(user1)
            );
        };
    }
}