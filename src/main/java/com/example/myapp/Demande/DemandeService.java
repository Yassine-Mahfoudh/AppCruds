package com.example.myapp.Demande;

import com.example.myapp.Departement.Departement;
import com.example.myapp.EtatDemande.EtatDemande;
import com.example.myapp.EtatDemande.EtatDemandeRepository;
import com.example.myapp.salle.Salle;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {
    public final DemandeRepository demandeRepository;
    public final EtatDemandeRepository etatDemandeRepository;

    public DemandeService(DemandeRepository demandeRepository,EtatDemandeRepository etatDemandeRepository) {
        this.demandeRepository = demandeRepository;
        this.etatDemandeRepository =etatDemandeRepository;
    }

    public List<Demande> getDemande(){
        return demandeRepository.findAll();
    }

    public Demande addNewDemande(Demande demande) {
        Optional<Demande> demandeOptional = demandeRepository
                .findDemandeByNom(demande.getNom());
        if (demandeOptional.isPresent()){
            throw new IllegalStateException("nom token");
        }
        return demandeRepository.save(demande);
    }
    public void deleteDemande(Long id){
        demandeRepository.findById(id);
        boolean exists= demandeRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "demande with id "+ id + " does not exists");
        }
        demandeRepository.deleteById(id);
    }
    @Transactional
    public Demande updateDemande(Demande demande) {

        return demandeRepository.save(demande);
    }


    public Demande findDemandeByNom(String nom) {
        return demandeRepository.findDemandeByNom(nom)
                .orElseThrow(() -> new IllegalStateException("Demande by name " + nom + " was not found"));
    }
    public List<EtatDemande> getEtatbyDemande(Long id) {
        return demandeRepository.getEtatbyDemande(id);

    }

    public void addEtatToDem(Long iddem, Long idetat) {
        Demande demande = demandeRepository.findDemandeById(iddem);
        EtatDemande etatDemande = etatDemandeRepository.findEtatDemandeById(idetat);
        demande.getEtatDemandes().add(etatDemande);
        demandeRepository.save(demande);
    }


}
