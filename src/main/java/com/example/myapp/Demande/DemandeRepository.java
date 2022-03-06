package com.example.myapp.Demande;

import com.example.myapp.EtatDemande.EtatDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeRepository
        extends JpaRepository<Demande,Long> {
    @Query("SELECT dem FROM Demande dem where dem.nom = ?1")

    Optional <Demande> findDemandeByNom(String nom);
    boolean existsByNom(String nom);
    void deleteByNom(String nom);

    Demande findDemandeById(Long id);
    @Query("SELECT dem.etatDemandes FROM Demande dem where dem.id = ?1")
    List<EtatDemande> getEtatbyDemande(Long id);
}
