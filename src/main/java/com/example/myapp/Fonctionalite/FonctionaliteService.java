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
//    public Fonctionalite addNewFonctionalite(Fonctionalite fonctionalite) {
//        Optional<Fonctionalite> fonctionaliteOptional = fonctionaliteRepository
//                .findFonctionaliteByNom(fonctionalite.getNom());
//        if (fonctionaliteOptional.isPresent()){
//            throw new IllegalStateException("nom token");
//        }
//        return fonctionaliteRepository.save(fonctionalite);
//    }
    public void deleteFonctionalite(Long id){
        fonctionaliteRepository.findById(id);
        boolean exists=fonctionaliteRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "fonctionalite with id "+ id + " does not exists");
        }
        fonctionaliteRepository.deleteById(id);
    }
    @Transactional
    public Fonctionalite updateFonctionalite(Fonctionalite fonctionalite) {

        return fonctionaliteRepository.save(fonctionalite);
    }

    public Fonctionalite findFonctionaliteById(Long id) {
        return fonctionaliteRepository.findFonctionaliteById(id)
                .orElseThrow(() -> new IllegalStateException("Fonctionalite by id " + id + " was not found"));
    }

}
