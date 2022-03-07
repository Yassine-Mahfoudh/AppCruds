package com.example.myapp.employee;

import com.example.myapp.Demande.Demande;
import com.example.myapp.salle.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee,Long> {
@Query("SELECT s FROM Employee s where s.nom = ?1")
Optional <Employee> findEmployeeByNom(String nom);

Employee findEmployeeById(Long id);

    boolean existsByNom(String nom);
    void deleteByNom(String nom);
    @Query("SELECT s FROM Employee s where s.nom = ?1")
    Set<Demande> getDemandebyEmployee(String nom);

}
