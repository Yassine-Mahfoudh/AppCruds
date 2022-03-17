package com.example.myapp.business.service;

import com.example.myapp.persistence.model.Demande;

import java.util.List;

public interface IDemandeService {
    public Demande getDemandeById(Long id);

    public List<Demande> getListDemande();

    public void deleteDemande(Long id);
    public Demande updateDemande(Demande demande,Long id);

    public Demande saveDemande(Demande dem);


}
