package com.example.myapp.Utilisateur;

import com.example.myapp.Fonctionalite.Fonctionalite;
import com.example.myapp.Profil.Profil;
import com.example.myapp.Profil.ProfilRepository;
import com.example.myapp.employee.Employee;
import com.example.myapp.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;

@Service

public class UtilisateurService {
    public final UtilisateurRepository utilisateurRepository;
    public final EmployeeRepository employeeRepository;
    public final ProfilRepository profilRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository, EmployeeRepository employeeRepository, ProfilRepository profilRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.employeeRepository=employeeRepository;

        this.profilRepository = profilRepository;
    }

    public List<Utilisateur> getUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public Utilisateur addNewUtilisateur(Utilisateur utilisateur) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository
                .findUtilisateurBylogin(utilisateur.getLogin());
        if (utilisateurOptional.isPresent()){
            throw new IllegalStateException("login token");
        }
        return utilisateurRepository.save(utilisateur);
    }
    @Transactional
    public void deleteUtilisateur(String login){
        utilisateurRepository.findUtilisateurBylogin(login);
        boolean exists=utilisateurRepository.existsByLogin(login);
        if (!exists){
            throw new IllegalStateException(
                    "utilisateur with login "+ login + " does not exists");
        }
        utilisateurRepository.deleteByLogin(login);
    }
    @Transactional
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {

        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur findUtilisateurByLogin(String login) {
        return utilisateurRepository.findUtilisateurBylogin(login)
                .orElseThrow(() -> new IllegalStateException("User by login " + login + " was not found"));
    }
    public void addEmpToUtilisateur(Long idemp , Long idU) {
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(idU);
        Employee employee = employeeRepository.findEmployeeById(idemp);
        utilisateur.setEmployee(employee);
        utilisateurRepository.save(utilisateur);
    }

//    public void addProfilToUtilisateur(Long idprofil, Long idU) {
//        Utilisateur utilisateur = utilisateurRepository.findUtilisateurById(idU);
//        Profil profil = profilRepository.findProfilById(idprofil);
//        utilisateur.getProfils().add(profil);
//        profilRepository.save(profil);
//    }
}
