package com.example.myapp.Projet;

import com.example.myapp.employee.Employee;
import com.example.myapp.salle.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjetRepository
        extends JpaRepository<Projet,Long> {
@Query("SELECT pj FROM Projet pj where pj.nom = ?1")
Optional<Projet> findProjetByNom(String nom);

    Projet findProjetById(Long id);

    boolean existsByNom(String nom);
    void deleteByNom(String nom);
    @Query("SELECT p.employees FROM Projet p where p.nom = ?1")
    List<Employee> getEmpbyProjet(String nom);

}
