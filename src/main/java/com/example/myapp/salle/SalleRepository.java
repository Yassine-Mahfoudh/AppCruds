package com.example.myapp.salle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalleRepository
        extends JpaRepository<Salle,Long> {
    @Query("SELECT s FROM Salle s where s.num = ?1")
    Salle findSalleByNum(int num);

    Optional <Salle> findSalleById(Long id);
}
