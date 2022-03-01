package com.example.myapp.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service

public class UtilisateurService {
    public final UtilisateurRepository utilisateurRepository;
    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public Utilisateur addNewUtilisateur(Utilisateur utilisateur) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository
                .findUtilisateurByemail(utilisateur.getEmail());
        if (utilisateurOptional.isPresent()){
            throw new IllegalStateException("email token");
        }
        return utilisateurRepository.save(utilisateur);
    }
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
}
