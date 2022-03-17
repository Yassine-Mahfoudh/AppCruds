package com.example.myapp.persistence.repository;

import com.example.myapp.persistence.model.EtatDemande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatDemandeRepository  extends JpaRepository<EtatDemande,Long> {
}
