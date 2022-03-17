package com.example.myapp.business.service.impl;

import antlr.Utils;
import ch.qos.logback.classic.pattern.Util;
import com.example.myapp.business.service.IDemandeService;
import com.example.myapp.persistence.model.Demande;
import com.example.myapp.persistence.repository.DemandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    public Demande addNewDemande(Demande demande) {
        return demandeRepository.save(demande);
    }
    @Transactional

    @Override
    public void deleteDemande(Long id) {
        Demande d = demandeRepository.findDemandeById(id);
    demandeRepository.delete(d);
    }
    @Transactional

    @Override
    public Demande updateDemande(Demande demande) {
        return demandeRepository.save(demande);
    }
}
