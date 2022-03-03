package com.example.myapp.Profil;

import com.example.myapp.Fonctionalite.Fonctionalite;
import com.example.myapp.Fonctionalite.FonctionaliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

public class ProfilService {
    public final ProfilRepository profilRepository;
    public final FonctionaliteRepository fonctionaliteRepository;
    @Autowired
    public ProfilService(ProfilRepository profilRepository, FonctionaliteRepository fonctionaliteRepository) {
        this.profilRepository = profilRepository;
        this.fonctionaliteRepository = fonctionaliteRepository;
    }

    public List<Profil> getProfils(){
        return profilRepository.findAll();
    }
    public Profil saveProfil(Profil profil) {
        return profilRepository.save(profil);
    }
//    public Profil addNewProfil(Profil profil) {
//        Optional<Profil> profilOptional = profilRepository
//                .findProfilBytype(profil.getType());
//        if (profilOptional.isPresent()){
//            throw new IllegalStateException("type token");
//        }
//        return profilRepository.save(profil);
//    }
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

    public void addFoncToProfil(String type, String nom) {
       Profil profil = profilRepository.findProfilBytype(type);
        Fonctionalite fonctionalite = fonctionaliteRepository.findFonctionaliteByNom(nom);
        profil.getFonctionalites().add(fonctionalite);
        profilRepository.save(profil);
    }
}
