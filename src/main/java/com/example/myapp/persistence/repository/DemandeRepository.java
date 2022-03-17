package com.example.myapp.persistence.repository;

import com.example.myapp.Demande.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository  extends JpaRepository<Demande,Long> {
}
