package com.example.myapp.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee,Long> {
@Query("SELECT s FROM Employee s where s.nom = ?1")

Optional <Employee> findEmployeeByNom(String nom);
Employee findEmployeeById(Long id);

    boolean existsByNom(String nom);
    void deleteByNom(String nom);

}
