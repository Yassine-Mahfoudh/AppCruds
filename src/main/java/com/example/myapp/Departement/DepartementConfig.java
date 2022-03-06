package com.example.myapp.Departement;

        import com.example.myapp.salle.Salle;
        import com.example.myapp.salle.SalleRepository;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

        import java.util.ArrayList;
        import java.util.List;

@Configuration
public class DepartementConfig {

    @Bean
    CommandLineRunner commandLineRunner8(
            DepartementRepository repository1,
            SalleRepository repository2){
        return args -> {

            Departement departement1 = new Departement("dep1", 1);
            Departement departement2 = new Departement("dep2", 2);
            Departement departement3 = new Departement("dep3", 3);


            Salle salle1 = new Salle(
                    "reunion",
                    11,
                    10,
                    50
            );

            Salle salle2 = new Salle(
                    "travail",
                    22,
                    15,
                    75
            );

            Salle salle3 = new Salle(
                    "projection",
                    33,
                    20,
                    100
            );


            repository1.saveAll(
                    List.of(departement1,departement2,departement3)
            );
            repository2.saveAll(
                    List.of(salle1,salle2,salle3)
            );

  };
        }
}
