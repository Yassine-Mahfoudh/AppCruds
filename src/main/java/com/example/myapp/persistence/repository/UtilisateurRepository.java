package com.example.myapp.persistence.repository;

import com.example.myapp.persistence.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    @Query("SELECT s FROM Utilisateur s where s.id=: id")
    public Utilisateur findUtilisateurById(@Param("id")Long id);

    @Query("SELECT u FROM Utilisateur u where u.login =: login")
    public  Utilisateur findUtilisateurByLogin(@Param("login") String login);
}
