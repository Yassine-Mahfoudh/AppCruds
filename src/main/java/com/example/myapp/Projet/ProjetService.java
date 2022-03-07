package com.example.myapp.Projet;

import com.example.myapp.employee.Employee;
import com.example.myapp.employee.EmployeeRepository;
import com.example.myapp.salle.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {
    public final ProjetRepository projetRepository;
    public  final EmployeeRepository employeeRepository;
@Autowired
    public ProjetService(ProjetRepository projetRepository, EmployeeRepository employeeRepository) {
        this.projetRepository = projetRepository;
    this.employeeRepository = employeeRepository;
}

    public List<Projet> getProjet(){

    return projetRepository.findAll();
    }

    public Projet addNewProjet(Projet projet) {
    Optional<Projet> projetOptional = projetRepository
            .findProjetByNom(projet.getNom());
    if (projetOptional.isPresent()){
        throw new IllegalStateException("project name token");
    }
     return projetRepository.save(projet);
    }
    public void deleteProjet(String nom){
        projetRepository.findProjetByNom(nom);
    boolean exists=projetRepository.existsByNom(nom);
        if (!exists){
            throw new IllegalStateException(
                    "project with name "+ nom + " does not exists");
        }
        projetRepository.deleteByNom(nom);
    }
@Transactional
public Projet updateProjet(Projet projet) {

    return projetRepository.save(projet);
}

    public Projet findProjetByNom(String nom) {
        return projetRepository.findProjetByNom(nom)
                .orElseThrow(() -> new IllegalStateException("project by name " + nom + " was not found"));
    }

    public List<Employee> getEmpByProjet(String nom) {

        return projetRepository.getEmpbyProjet(nom);
    }
    public void addEmpToProjet(Long idprojet , Long idemp) {
        Projet projet = projetRepository.findProjetById(idprojet);
        Employee employee = employeeRepository.findEmployeeById(idemp);
        projet.getEmployees().add(employee);
        projetRepository.save(projet);
    }


}
