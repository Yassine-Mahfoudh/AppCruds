package com.example.myapp.Profil;

import com.example.myapp.Fonctionalite.Fonctionalite;
import com.example.myapp.Fonctionalite.FonctionaliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
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
    public Profil addNewProfil(Profil profil) {
        Optional<Profil> profilOptional = profilRepository
                .findProfilByType(profil.getType());
        if (profilOptional.isPresent()){
            throw new IllegalStateException("type token");
        }
        return profilRepository.save(profil);
    }
    @Transactional
    public void deleteProfil(String type){
        profilRepository.findProfilByType(type);
        boolean exists=profilRepository.existsByType(type);
        if (!exists){
            throw new IllegalStateException(
                    "profil with type "+ type + " does not exists");
        }
        profilRepository.deleteByType(type);
    }
    @Transactional
    public Profil updateProfil(Profil profil) {

        return profilRepository.save(profil);
    }

    public Profil findProfilByType(String type) {
        return profilRepository.findProfilByType(type)
                .orElseThrow(() -> new IllegalStateException("Profil by type " + type + " was not found"));
    }

    public void addFoncToProfil(Long idprofil, Long idfonc) {
       Profil profil = profilRepository.findProfilById(idprofil);
        Fonctionalite fonctionalite = fonctionaliteRepository.findFonctionaliteById(idfonc);
        profil.getFonctionalites().add(fonctionalite);
        profilRepository.save(profil);


    }
}
