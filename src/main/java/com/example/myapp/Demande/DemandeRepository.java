//package com.example.myapp.Demande;
//
//import com.example.myapp.persistence.model.Demande;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public interface DemandeRepository
//        extends JpaRepository<Demande,Long> {
//    @Query("SELECT dem FROM Demande dem where dem.nom = ?1")
//
//    Optional <Demande> findDemandeByNom(String nom);
//    boolean existsByNom(String nom);
//    void deleteByNom(String nom);
//
//
//}
