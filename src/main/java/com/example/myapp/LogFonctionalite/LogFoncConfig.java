package com.example.myapp.LogFonctionalite;

import com.example.myapp.Fonctionalite.Fonctionalite;
import com.example.myapp.Fonctionalite.FonctionaliteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class LogFoncConfig {@Bean
CommandLineRunner commandLineRunner5(
                LogFoncRepository repository){
    return args -> {
        LogFonc lf1 = new LogFonc (
                LocalDate.of(2022,4,2),
                LocalTime.of(10,24,45),
                LocalTime.of(14,41,45)

        );
        LogFonc lf2 = new LogFonc (
                LocalDate.of(2021,6,8),
                LocalTime.of(12,24,45),
                LocalTime.of(13,41,45)

        );

        repository.saveAll(
                List.of(lf1,lf2)
        );
    };
}
}
