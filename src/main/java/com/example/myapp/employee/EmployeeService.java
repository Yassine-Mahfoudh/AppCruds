package com.example.myapp.employee;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class EmployeeService {
    public final EmployeeRepository employeeRepository;


    public List<Employee> getEmployees(){

    return employeeRepository.findAll();
    }

    public Employee addNewEmployee(Employee employee) {
    Optional<Employee> employeeOptional = employeeRepository
            .findEmployeeByNom(employee.getNom());
    if (employeeOptional.isPresent()){
        throw new IllegalStateException("nom token");
    }
     return employeeRepository.save(employee);
    }
    @Transactional

    public void deleteEmployee(String nom){
    employeeRepository.findEmployeeByNom(nom);
    boolean exists=employeeRepository.existsByNom(nom);
        if (!exists){
            throw new IllegalStateException(
                    "employee with nom "+ nom + " does not exists");
        }
        employeeRepository.deleteByNom(nom);
    }
@Transactional
public Employee updateEmployee(Employee employee) {

    return employeeRepository.save(employee);
}

    public Employee findEmployeeByNom(String nom) {
        return employeeRepository.findEmployeeByNom(nom)
                .orElseThrow(() -> new IllegalStateException("Employee by nom " + nom + " was not found"));
    }
//    public Set<Demande> getDemandebyEmployee(String nom) {
//
//        return employeeRepository.getDemandebyEmployee(nom);
//    }
//
//    public void addDemandeToEmployee(Long idemp, Long iddem) {
//        Employee employee = employeeRepository.findEmployeeById(idemp);
//        Demande demande = demandeRepository.findDemandeById(iddem);
//        employee.getDemandes().add(demande);
//        employeeRepository.save(employee);
//    }
//


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
