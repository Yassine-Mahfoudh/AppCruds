package com.example.myapp.persistence.repository;

import com.example.myapp.persistence.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
