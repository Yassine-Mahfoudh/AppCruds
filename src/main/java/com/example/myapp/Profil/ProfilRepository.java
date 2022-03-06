package com.example.myapp.Profil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProfilRepository extends JpaRepository<Profil,Long> {
    @Query("SELECT s FROM Profil s where s.type = ?1")
    Optional <Profil> findProfilByType(String type);

    Profil findProfilById(Long id);

    boolean existsByType(String type);
    void deleteByType(String type);

}
