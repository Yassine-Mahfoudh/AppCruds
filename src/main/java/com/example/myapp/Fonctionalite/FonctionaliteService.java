package com.example.myapp.Fonctionalite;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class FonctionaliteService {
    public final FonctionaliteRepository fonctionaliteRepository;
    @Autowired
    public FonctionaliteService(FonctionaliteRepository fonctionaliteRepository) {
        this.fonctionaliteRepository = fonctionaliteRepository;
    }

    public List<Fonctionalite> getFonctionalites(){
        return fonctionaliteRepository.findAll();
    }
    public Fonctionalite saveFonctionalite(Fonctionalite fonctionalite) {
        return fonctionaliteRepository.save(fonctionalite);
    }
    public Fonctionalite addNewFonctionalite(Fonctionalite fonctionalite) {
        Optional<Fonctionalite> fonctionaliteOptional = fonctionaliteRepository
                .findFonctionaliteByNom(fonctionalite.getNom());
        if (fonctionaliteOptional.isPresent()){
            throw new IllegalStateException("nom token");
        }
        return fonctionaliteRepository.save(fonctionalite);
    }
    @Transactional
    public void deleteFonctionalite(String nom){
        fonctionaliteRepository.findFonctionaliteByNom(nom);
        boolean exists=fonctionaliteRepository.existsByNom(nom);
        if (!exists){
            throw new IllegalStateException(
                    "fonctionalite with name "+ nom + " does not exists");
        }
        fonctionaliteRepository.deleteByNom(nom);
    }
    @Transactional
    public Fonctionalite updateFonctionalite(Fonctionalite fonctionalite) {

        return fonctionaliteRepository.save(fonctionalite);
    }

    public Fonctionalite findFonctionaliteByNom(String nom) {
        return fonctionaliteRepository.findFonctionaliteByNom(nom)
                .orElseThrow(() -> new IllegalStateException("Fonctionalite by nom " + nom + " was not found"));
    }

}
