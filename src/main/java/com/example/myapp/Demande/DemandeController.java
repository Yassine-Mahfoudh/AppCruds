package com.example.myapp.Demande;

import com.example.myapp.EtatDemande.EtatDemande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/demande")
public class DemandeController {
    private final DemandeService demandeService;
    @Autowired
    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @GetMapping
    public List<Demande> getDemande() {
        return demandeService.getDemande();
    }

    @PostMapping("/add")
    public ResponseEntity<Demande> addDemande(@RequestBody Demande demande){
        Demande newDemande = demandeService.addNewDemande(demande);
        return new ResponseEntity<>(newDemande, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{nom}")
    public ResponseEntity<?> deleteDemande(@PathVariable("nom") String nom) {
        demandeService.deleteDemande(nom);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Demande> updateDemande(@RequestBody Demande demande) {
        Demande updateDemande = demandeService.updateDemande(demande);
        return new ResponseEntity<>(updateDemande, HttpStatus.OK);
    }


    @GetMapping("/find/{nom}")
    public ResponseEntity<Demande> getDemandeByNom (@PathVariable("nom") String nom) {
        Demande demande = demandeService.findDemandeByNom(nom);
        return new ResponseEntity<>(demande, HttpStatus.OK);}

    @GetMapping("/find/{id}/etatdemande")
    public List<EtatDemande> getEtatbyDemande(@PathVariable("id") Long id) {
        return demandeService.getEtatbyDemande(id); }


    @PostMapping("/etat/addtodem")
    public ResponseEntity<?> addEtatToDemande(@RequestBody EtatToDemandeForm form){
        demandeService.addEtatToDem(form.getIddem(),form.getIdetat());
        return ResponseEntity.ok().build();
    }

}
class EtatToDemandeForm{
    private Long iddem;
    private Long idetat;

    public Long getIddem() {
        return iddem;
    }

    public void setIddem(Long iddem) {
        this.iddem = iddem;
    }

    public Long getIdetat() {
        return idetat;
    }

    public void setIdetat(Long idetat) {
        this.idetat = idetat;
    }
}
