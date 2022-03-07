package com.example.myapp.TypeDemande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeDemandeRepository
        extends JpaRepository<TypeDemande,Long> {
    @Query("SELECT t FROM TypeDemande t where t.id = ?1")
    TypeDemande findTypeDemandeById(Long id) ;

    boolean existsById(Long id);
    void deleteById(Long id);
}

