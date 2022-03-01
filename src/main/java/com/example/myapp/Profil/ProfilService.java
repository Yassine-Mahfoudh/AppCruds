package com.example.myapp.Profil;

import com.example.myapp.Utilisateur.Utilisateur;
import com.example.myapp.Utilisateur.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

public class ProfilService {
    public final ProfilRepository profilRepository;
    @Autowired
    public ProfilService(ProfilRepository profilRepository) {
        this.profilRepository = profilRepository;
    }

    public List<Profil> getProfils(){
        return profilRepository.findAll();
    }

    public Profil addNewProfil(Profil profil) {
        Optional<Profil> profilOptional = profilRepository
                .findProfilBytype(profil.getType());
        if (profilOptional.isPresent()){
            throw new IllegalStateException("type token");
        }
        return profilRepository.save(profil);
    }
    public void deleteProfil(Long id){
        profilRepository.findById(id);
        boolean exists=profilRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "profil with id "+ id + " does not exists");
        }
        profilRepository.deleteById(id);
    }
    @Transactional
    public Profil updateProfil(Profil profil) {

        return profilRepository.save(profil);
    }

    public Profil findProfilById(Long id) {
        return profilRepository.findProfilById(id)
                .orElseThrow(() -> new IllegalStateException("Profil by id " + id + " was not found"));
    }
}
