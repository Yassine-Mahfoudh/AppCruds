package com.example.myapp.Fonctionalite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FonctionaliteRepository extends JpaRepository<Fonctionalite,Long> {
@Query("SELECT s FROM Fonctionalite s where s.nom = ?1")
Optional<Fonctionalite> findFonctionaliteByNom(String nom);

        Optional <Fonctionalite> findFonctionaliteById(Long id);
}
