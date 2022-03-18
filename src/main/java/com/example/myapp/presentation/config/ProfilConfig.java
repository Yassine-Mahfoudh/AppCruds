package com.example.myapp.presentation.config;

import com.example.myapp.persistence.model.Profil;
import com.example.myapp.persistence.repository.ProfilRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
@Configuration
public class ProfilConfig {
    @Bean
    CommandLineRunner commandLineRunner33(
            ProfilRepository profilRepository) {
        return args -> {
            Profil profil1 = new Profil(
                    "admin",
                    LocalDate.of(2022, 2, 27)
            );
            Profil profil2 = new Profil(
                    "manager",
                    LocalDate.of(2022, 3, 3)
            );
            profilRepository.saveAll(
                    List.of(profil1, profil2)
            );
        };
    }
}