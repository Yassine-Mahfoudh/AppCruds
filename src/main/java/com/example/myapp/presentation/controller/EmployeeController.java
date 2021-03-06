package com.example.myapp.presentation.controller;

import com.example.myapp.business.service.IEmployeeService;
import com.example.myapp.persistence.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
@AllArgsConstructor
public class EmployeeController {

    public final IEmployeeService iEmployeeService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getListEmployee() {
        try {
            return iEmployeeService.getListEmployee();
        } catch (Exception e) {
            throw new IllegalStateException("Error EmployeeController in method getListEmployee :: " + e.toString());
        }
    }

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        try {
            Employee employee = iEmployeeService.getEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalStateException("Error EmployeeController in method getEmployeeById :: " + e.toString());
        }
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee addEmployee(@RequestBody Employee employee) {
        try {
            return iEmployeeService.addEmployee(employee);
        } catch (Exception e) {
            throw new IllegalStateException("Error EmployeeController in method addEmployee :: " + e.toString());
        }
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee, @PathVariable("id") Long id) {
        try {
            Employee updateEmployee = iEmployeeService.updateEmployeeById(employee, id);
            return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalStateException("Error EmployeeController in method updateEmployeeById :: " + e.toString());
        }
    }

    @DeleteMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id) {
        try {
            iEmployeeService.deleteEmployeeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalStateException("Error EmployeeController in method deleteEmployeeById :: " + e.toString());
        }
    }
}
