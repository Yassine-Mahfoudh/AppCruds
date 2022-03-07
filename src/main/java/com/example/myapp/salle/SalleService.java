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
        Optional<Salle> SalleOptional = salleRepository
                .findSalleByNum(Salle.getNum());
        if (SalleOptional.isPresent()){
            throw new IllegalStateException("num token");
        }
        return salleRepository.save(Salle);
    }
    @Transactional
    public void deleteSalle(int num){
        salleRepository.findSalleByNum(num);
        boolean exists= salleRepository.existsByNum(num);
        if (!exists){
            throw new IllegalStateException(
                    "salle with num "+ num + " does not exists");
        }
        salleRepository.deleteByNum(num);
    }
    @Transactional
    public Salle updateSalle(Salle Salle) {

        return salleRepository.save(Salle);
    }

    public Salle findSalleByNum(int num) {
        return salleRepository.findSalleByNum(num)
                .orElseThrow(() -> new IllegalStateException(" salle with num " + num + " does not exists"));
    }

    public List<Employee> getEmpBySalle(int num) {

        return salleRepository.getEmpbySalle(num);
    }
    public void addEmpToSalle(Long idsalle, Long idemp) {
        Salle salle = salleRepository.findSalleById(idsalle);
        Employee employee = employeeRepository.findEmployeeById(idemp);
        salle.getEmployees().add(employee);
        salleRepository.save(salle);
    }

}
