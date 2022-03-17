package com.example.myapp.presentation.controller;

import com.example.myapp.business.service.IDemandeService;
import com.example.myapp.persistence.model.Demande;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public List<Demande> getDemande() {
        return iDemandeService.getListDemande();

    }

    @PostMapping("/add")
    public ResponseEntity<Demande> addNewDemande(@RequestBody Demande demande){
        Demande newDemande = iDemandeService.addNewDemande(demande);
        return new ResponseEntity<>(newDemande, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDemande(@PathVariable("id") Long id) {
        iDemandeService.deleteDemande(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Demande> updateDemande(@RequestBody Demande demande) {
        Demande updateDemande = iDemandeService.updateDemande(demande);
        return new ResponseEntity<>(updateDemande, HttpStatus.OK);
    }


}
