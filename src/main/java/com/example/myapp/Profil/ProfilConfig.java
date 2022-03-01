package com.example.myapp.Profil;

import com.example.myapp.Utilisateur.Utilisateur;
import com.example.myapp.Utilisateur.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProfilConfig {
    @Bean
    CommandLineRunner commandLineRunner3(
            ProfilRepository repository){
        return args -> {
            Profil profil1 = new Profil (
                    "admin"
            );
            Profil profil2 = new Profil (
                    "manager"
            );
            repository.saveAll(
                    List.of(profil1,profil2)
            );
        };
    }
}
