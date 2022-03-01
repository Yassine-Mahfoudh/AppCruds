package com.example.myapp.Utilisateur;

import com.example.myapp.employee.Employee;
import com.example.myapp.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/utilisateur")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {

        this.utilisateurService =  utilisateurService;
    }

    @GetMapping
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurService.getUtilisateurs();
    }

    @PostMapping("/add")
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur){
        Utilisateur newUtilisateur=utilisateurService.addNewUtilisateur(utilisateur);
        return new ResponseEntity<>(newUtilisateur ,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") Long id) {
        utilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur updateUtilisateur = utilisateurService.updateUtilisateur(utilisateur);
        return new ResponseEntity<>(updateUtilisateur, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById (@PathVariable("id") Long id) {
        Utilisateur utilisateur = utilisateurService.findUtilisateurById(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

}
