package com.example.myapp.presentation.controller;

import com.example.myapp.business.service.IUtilisateurService;
import com.example.myapp.persistence.model.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/utilisateur")
@AllArgsConstructor
public class UtilisateurController {
    private final IUtilisateurService iUtilisateurService;

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Utilisateur> getUtilisateurById (@PathVariable("id") Long id) {
       try{ Utilisateur utilisateur = iUtilisateurService.getUtilisateurById(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);}
       catch (Exception e){
           throw new IllegalStateException("Error UtilisateurController in method getUtilisateurById:" +e.toString());
       }
    }
    @GetMapping
    public List<Utilisateur> getListUtilisateur() {
        try {
            return iUtilisateurService.getListUtilisateur();
        }catch(Exception e){
            throw new IllegalStateException("Error UtilisateurController in method getListUtilisateur:" +e.toString());
        }

    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Utilisateur addUtilisateur(@RequestBody Utilisateur obj){
       try{
          return iUtilisateurService.addUtilisateur(obj);
       }catch(Exception e){
           throw new IllegalStateException("Error UtilisateurController in method addUtilisateur:" +e.toString());
       }

    }
    @DeleteMapping(value="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") Long id) {
        try{
            iUtilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            throw new IllegalStateException("Error UtilisateurController in method deleteUtilisateur:" +e.toString());
        }
    }
    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur obj,Long id) {
        try {
            Utilisateur updateUtilisateur = iUtilisateurService.updateUtilisateur(obj, id);
        return new ResponseEntity<>(updateUtilisateur, HttpStatus.OK);
    }catch(Exception e){
        throw new IllegalStateException("Error UtilisateurController in method updateUtilisateur:" +e.toString());
    }
}
    }
