package com.example.myapp.Utilisateur;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class UtilisateurConfig {
    @Bean
    CommandLineRunner commandLineRunner2(
            UtilisateurRepository repository){
        return args -> {
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
            repository.saveAll(
                    List.of(salah,oussama)
            );
        };
    }

}
