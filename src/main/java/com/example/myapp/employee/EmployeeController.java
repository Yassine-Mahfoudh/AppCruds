package com.example.myapp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService =  employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
       return employeeService.getEmployees();
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee=employeeService.addNewEmployee(employee);
        return new ResponseEntity<>(newEmployee ,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{nom}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("nom") String nom) {
        employeeService.deleteEmployee(nom);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @GetMapping("/find/{nom}")
    public ResponseEntity<Employee> getEmployeeByNom (@PathVariable("nom") String nom) {
        Employee employee = employeeService.findEmployeeByNom(nom);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /*@PutMapping(path = "{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String adresse){
        employeeService.updateEmployee(id,nom,adresse);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
