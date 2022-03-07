package com.example.myapp.salle;

import com.example.myapp.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalleRepository
        extends JpaRepository<Salle,Long> {
    @Query("SELECT s FROM Salle s where s.num = ?1")
    Optional <Salle> findSalleByNum(int num);

    boolean existsByNum(int num);
    void deleteByNum(int num);

    Salle findSalleById(Long id);
    @Query("SELECT s.employees FROM Salle s where s.num = ?1")
    List<Employee> getEmpbySalle(int num);
}
