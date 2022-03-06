package com.example.myapp.LogAccess;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogAccessService {
    public final LogAccessRepository logAccessRepository;

    public LogAccessService(LogAccessRepository logAccessRepository) {
        this.logAccessRepository = logAccessRepository;
    }

    public List<LogAccess> getLogAccess(){
        return logAccessRepository.findAll();
    }


    public LogAccess findLogAccessById(Long id) {
        return logAccessRepository.findLogAccessById(id)
                .orElseThrow(() -> new IllegalStateException("log by id " + id + " was not found"));
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
