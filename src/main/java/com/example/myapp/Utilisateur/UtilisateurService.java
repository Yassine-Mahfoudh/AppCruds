package com.example.myapp.Utilisateur;

import com.example.myapp.Fonctionalite.Fonctionalite;
import com.example.myapp.Profil.Profil;
import com.example.myapp.employee.Employee;
import com.example.myapp.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service

public class UtilisateurService {
    public final UtilisateurRepository utilisateurRepository;
    public final EmployeeRepository employeeRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository, EmployeeRepository employeeRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.employeeRepository=employeeRepository;

    }

    public List<Utilisateur> getUtilisateurs(){
        return utilisateurRepository.findAll();
    }

//    public Utilisateur addNewUtilisateur(Utilisateur utilisateur) {
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository
//                .findUtilisateurBylogin(utilisateur.getEmail());
//        if (utilisateurOptional.isPresent()){
//            throw new IllegalStateException("email token");
//        }
//        return utilisateurRepository.save(utilisateur);
//    }
    public void deleteUtilisateur(Long id){
        utilisateurRepository.findById(id);
        boolean exists=utilisateurRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "utilisateur with id "+ id + " does not exists");
        }
        utilisateurRepository.deleteById(id);
    }
    @Transactional
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {

        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur findUtilisateurById(Long id) {
        return utilisateurRepository.findUtilisateurById(id)
                .orElseThrow(() -> new IllegalStateException("User by id " + id + " was not found"));
    }
    public void addEmpToUtilisateur(String nom, String login) {
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurBylogin(login);
        Employee employee = employeeRepository.findEmployeeByNom(nom);
        utilisateur.setEmployee(employee);
        utilisateurRepository.save(utilisateur);
    }
}
