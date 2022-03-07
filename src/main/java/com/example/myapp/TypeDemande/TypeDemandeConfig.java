package com.example.myapp.TypeDemande;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TypeDemandeConfig {

    @Bean
    CommandLineRunner commandLineRunner18(
            TypeDemandeRepository typeDemandeRepository){
        return args -> {

            TypeDemande type1 = new TypeDemande("presence");
            TypeDemande type2 = new TypeDemande("conger");

            typeDemandeRepository.saveAll(
                    List.of(type1,type2)
            );


        };
    }
}