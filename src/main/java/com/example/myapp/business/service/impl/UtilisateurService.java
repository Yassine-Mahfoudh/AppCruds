package com.example.myapp.business.service.impl;

import com.example.myapp.business.service.IUtilisateurService;
import com.example.myapp.persistence.model.Utilisateur;
import com.example.myapp.persistence.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class UtilisateurService implements IUtilisateurService{
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getListUtilisateur(){
        try {
            return utilisateurRepository.findAll();
        } catch (Exception e) {
            throw  new IllegalStateException("Error UtilisateurService in method getListUtilisateur " + e.toString());
        }
    }
    @Override
    public Utilisateur getUtilisateurById(Long id) {
        try {
            if(id == null)
                return new Utilisateur();
            Utilisateur p = utilisateurRepository.findUtilisateurById(id);
            if ( p == null )
                return new Utilisateur();
            return p;
        } catch (Exception e) {
            throw new IllegalStateException("Error UtilisateurService in method getUtilisateurById :: " + e.toString());
        }
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur obj) {
        try {
            Utilisateur objNomUnique = utilisateurRepository.findUtilisateurByLogin(obj.getLogin());
            if (objNomUnique != null)
                throw new IllegalStateException("Utilisateur login token");
            obj.setDatecreation(new Timestamp(new Date().getTime()));
            return utilisateurRepository.save(obj);
        } catch (Exception e) {
            throw  new IllegalStateException("Error UtilisateurService in method addUtilisateur " + e.toString());
        }
    }

    @Transactional
    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur,Long id) {
        try {
            Utilisateur obj = utilisateurRepository.findUtilisateurById(id);
           obj.setLogin(utilisateur.getLogin());
           obj.setMotdepasse(utilisateur.getMotdepasse());
           obj.setEmail(utilisateur.getEmail());
           obj.setDateupdate(new Timestamp(new Date().getTime()));
           obj.setId(id);
            return utilisateurRepository.save(obj);
        } catch (Exception e) {
            throw new IllegalStateException("Error UtilisateurService in method updateUtilisateur : " + e.toString());
        }

    }
    @Transactional
    @Override
    public void deleteUtilisateur(Long id) {
        try {
            utilisateurRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new IllegalStateException("Error UtilisateurService in method deleteUtilisateur : " + e.toString());
        }
    }
}



