package com.example.myapp.presentation.controller;

import com.example.myapp.business.service.IDemandeService;
import com.example.myapp.persistence.model.Demande;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(path = "/demande")
@AllArgsConstructor
public class DemandeController {
    private final IDemandeService iDemandeService;

    @GetMapping("/find/{id}")
    public ResponseEntity<Demande> getDemandeById (@PathVariable("id") Long id) {
        Demande demande = iDemandeService.getDemandeById(id);
        return new ResponseEntity<>(demande, HttpStatus.OK);
    }
    @GetMapping
    public List<Demande> getDemandes() {
        return iDemandeService.getListDemande();

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDemande(@PathVariable("id") Long id) {
        iDemandeService.deleteDemande(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Demande> updateDemande(@RequestBody Demande demande,@PathVariable("id") Long id) {
        Demande updateDemande = iDemandeService.updateDemande(demande,id);
        return new ResponseEntity<>(updateDemande, HttpStatus.OK);

    }

    @PostMapping(value="/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Demande saveDemande( @RequestBody Demande demande) {
        try {
            return iDemandeService.saveDemande(demande);
        } catch (Exception e) {
            throw new IllegalStateException("erreur"+e);
        }
    }

//    @PutMapping(value="/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Demande updateDemande( @RequestBody Demande demande) {
//        try {
//            return iDemandeService.saveOrUpdateDemande(demande,1);
//        } catch (Exception e) {
//            throw new IllegalStateException("erreur"+e);
//        }
//    }

}
