package com.example.myapp.Profil;

import com.example.myapp.Fonctionalite.Fonctionalite;
import com.example.myapp.Fonctionalite.FonctionaliteService;
import com.example.myapp.Utilisateur.Utilisateur;
import com.example.myapp.Utilisateur.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProfilConfig {
    @Bean
    CommandLineRunner commandLineRunner3(
            ProfilService profilService, FonctionaliteService fonctionaliteService,ProfilRepository profilRepository){
        return args -> {
            Profil profil1 = new Profil (
                    "admin",
                    LocalDate.of(2022,2,27),
                    new ArrayList<>()
            );
            Profil profil2 = new Profil (
                    "manager",
                    LocalDate.of(2022,3,3),
                    new ArrayList<>()
            );
            profilRepository.saveAll(
                    List.of(profil1,profil2)
            );
//
//                    fonctionaliteService.saveFonctionalite(new Fonctionalite("gerer salle","RH"));
//                    fonctionaliteService.saveFonctionalite(new Fonctionalite("gerer demandes","manager"));
//                    fonctionaliteService.saveFonctionalite(new Fonctionalite("gerer users","admin"));
//
//
//            profilService.saveProfil(new Profil("admin",LocalDate.of(2022,2,27),new ArrayList<>()));
//            profilService.saveProfil(new Profil("RH",LocalDate.of(2022,3,28),new ArrayList<>()));
//            profilService.saveProfil(new Profil("manager",LocalDate.of(2022,4,29),new ArrayList<>()));
//
//            profilService.addFoncToProfil("admin","gerer users");
//            profilService.addFoncToProfil("admin","gerer demandes");
//            profilService.addFoncToProfil("admin","gerer salle");
//            profilService.addFoncToProfil("RH","gerer salle");
//            profilService.addFoncToProfil("manager","gerer demandes");
//

        };
    }
}
