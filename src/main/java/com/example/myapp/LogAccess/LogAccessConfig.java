package com.example.myapp.LogAccess;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class LogAccessConfig {

    @Bean
    CommandLineRunner commandLineRunner25(
            LogAccessRepository repository4){
        return args -> {
            LogAccess log1 = new LogAccess(
                    LocalDate.of(2022,3,28),
                    "14",
                    "16"
            );
            LogAccess log2 = new LogAccess(
                    LocalDate.of(2022,3,28),
                    "9",
                    "12"
            );
            repository4.saveAll(
                    List.of(log1,log2)
            );
        };
    }

}
