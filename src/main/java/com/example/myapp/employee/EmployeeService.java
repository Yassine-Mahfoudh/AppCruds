package com.example.myapp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    public final EmployeeRepository employeeRepository;
@Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

//    public Employee addNewEmployee(Employee employee) {
//    Optional<Employee> employeeOptional = employeeRepository
//            .findEmployeeByNom(employee.getNom());
//    if (employeeOptional.isPresent()){
//        throw new IllegalStateException("nom token");
//    }
//     return employeeRepository.save(employee);
//    }
    public void deleteEmployee(Long id){
    employeeRepository.findById(id);
    boolean exists=employeeRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "employee with id "+ id + " does not exists");
        }
        employeeRepository.deleteById(id);
    }
@Transactional
public Employee updateEmployee(Employee employee) {

    return employeeRepository.save(employee);
}

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new IllegalStateException("User by id " + id + " was not found"));
    }



   /* public void updateEmployee (Long id,
                                    String nom,
                                    String adresse){
    Employee employee=employeeRepository.findById(id)
            .orElseThrow(()-> new IllegalStateException(
                    "employee with id" + id + "does not exist"));
    if (nom!=null &&
    nom.length() > 0 && !Objects.equals(employee.getNom(),nom)){
        employee.setNom(nom);
    }
    if (adresse!=null &&
            adresse.length() > 0 && !Objects.equals(employee.getAdresse(),adresse)){
        employee.setAdresse(adresse);
    }

    }*/
}
