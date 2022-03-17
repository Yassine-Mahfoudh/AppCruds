package com.example.myapp.business.service.impl;


import com.example.myapp.business.service.IDemandeService;
import com.example.myapp.persistence.model.Demande;
import com.example.myapp.persistence.repository.DemandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Service
public class DemandeService implements IDemandeService {
    public final DemandeRepository demandeRepository;

    @Override
    public Demande getDemandeById(Long id){
        if(id==null)
            return new Demande();
        Demande d= demandeRepository.findDemandeById(id);
        if(d == null)
            return new Demande();
        return d;

    }

    @Override
    public List<Demande> getListDemande() {

        return demandeRepository.findAll();
    }

//    @Override
//    public Demande addNewDemande(Demande demande) {
//        return demandeRepository.save(demande);
//    }
//
    @Transactional
    @Override
    public void deleteDemande(Long id) {
        Demande d = demandeRepository.findDemandeById(id);
    demandeRepository.delete(d);
    }
//    @Override
//    public Demande updateDemande(Demande demande) {
//        return demandeRepository.save(demande);
//    }

    @Transactional
    @Override
    public Demande saveDemande(Demande dem) {
        try {
            Demande objNomUnique = demandeRepository.findDemandeByNom(dem.getNom());
//
            if ( objNomUnique != null)
                throw new IllegalStateException("Demandee name token");

                dem.setDatecreation(new Timestamp(new Date().getTime()));
                
            return demandeRepository.save(dem);
        } catch (Exception e) {
            throw new IllegalStateException("erreur"+e);
        }
    }
}
