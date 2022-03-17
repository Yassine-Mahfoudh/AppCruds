package com.example.myapp.salle;

import com.example.myapp.employee.Employee;
import com.example.myapp.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SalleService {
    public final SalleRepository salleRepository;
    public final EmployeeRepository employeeRepository;

    public SalleService(SalleRepository salleRepository, EmployeeRepository employeeRepository) {
        this.salleRepository = salleRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Salle> getSalle(){
        return salleRepository.findAll();
    }

    public Salle addNewSalle(Salle Salle) {
        return salleRepository.save(Salle);
    }
    @Transactional
    public void deleteSalle(Long id){

        salleRepository.deleteById(id);
    }
    @Transactional
    public Salle updateSalle(Salle Salle) {

        return salleRepository.save(Salle);
    }

    public Salle findSalleById(Long id) {
        return salleRepository.findSalleById(id);
    }

//    public List<Employee> getEmpBySalle(int num) {
//
//        return salleRepository.getEmpbySalle(num);
//    }
//    public void addEmpToSalle(Long idsalle, Long idemp) {
//        Salle salle = salleRepository.findSalleById(idsalle);
//        Employee employee = employeeRepository.findEmployeeById(idemp);
//        salle.getEmployees().add(employee);
//        salleRepository.save(salle);
//    }

}
