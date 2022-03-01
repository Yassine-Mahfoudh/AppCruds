package com.example.myapp.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    @Query("SELECT s FROM Utilisateur s where s.email = ?1")
    Optional<Utilisateur> findUtilisateurByemail(String email);

    Optional <Utilisateur> findUtilisateurById(Long id);
}
