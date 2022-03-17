package com.example.myapp.persistence.repository;

import com.example.myapp.persistence.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository
        extends JpaRepository<Demande,Long> {
//@Query("SELECT dem FROM Demande WHERE dem.id=id")
//    public Demande findDemandeById(@Param("id") Long id);
    @Query("SELECT dem FROM Demande dem where dem.id = ?1")
    Demande findDemandeById(Long id);

}
