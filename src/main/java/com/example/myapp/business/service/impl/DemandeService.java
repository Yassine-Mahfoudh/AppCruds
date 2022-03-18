package com.example.myapp.business.service.impl;


import com.example.myapp.business.service.IDemandeService;
import com.example.myapp.persistence.model.Demande;
import com.example.myapp.persistence.repository.DemandeRepository;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.bcel.ExceptionRange;
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
    public List<Demande> getListDemande() {
        try {
            return demandeRepository.findAll();
        } catch (Exception e){
            throw new IllegalStateException("Error DemandeService in method getListDemande :: " + e.toString());

        }
    }

    @Override
    public Demande getDemandeById(Long id){
        try {
            if (id == null)
                return new Demande();
            Demande d = demandeRepository.findDemandeById(id);
            if (d == null)
                return new Demande();
            return d;
        } catch (Exception e){
            throw new IllegalStateException("Error DemandeService in method getDemandeById :: " + e.toString());
        }

    }


    @Override
    public Demande addDemande(Demande dem) {
        try {
            Demande objNomUnique = demandeRepository.findDemandeByNom(dem.getNom());

            if ( objNomUnique != null)
                throw new IllegalStateException("Demande name token");

                dem.setDatecreation(new Timestamp(new Date().getTime()));

            return demandeRepository.save(dem);
        } catch (Exception e) {
            throw new IllegalStateException("Error DemandeService in method addDemande :: " + e.toString());
        }
    }
    @Transactional
    @Override
    public Demande updateDemandeById(Demande demande,Long id) {
        try {
            Demande updem = demandeRepository.findDemandeById(id);
            updem.setNom(demande.getNom());
            updem.setMotif(demande.getMotif());
            updem.setDateupdate(new Timestamp(new Date().getTime()));
            updem.setId(id);

            return demandeRepository.save(updem);
        }
        catch (Exception e) {
            throw new IllegalStateException("Error DemandeService in method updateDemandeById :: " + e.toString());
        }
    }

    @Transactional
    @Override
    public void deleteDemandeById(Long id) {
        try {
            Demande d = demandeRepository.findDemandeById(id);
            demandeRepository.delete(d);
        }
        catch (Exception e) {
            throw new IllegalStateException("Error DemandeService in method deleteDemandeById :: " + e.toString());
        }
    }
}
