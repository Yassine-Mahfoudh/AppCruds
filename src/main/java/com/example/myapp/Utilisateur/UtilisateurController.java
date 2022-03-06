package com.example.myapp.Utilisateur;


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
    @DeleteMapping("/delete/{login}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("login") String login) {
        utilisateurService.deleteUtilisateur(login);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur updateUtilisateur = utilisateurService.updateUtilisateur(utilisateur);
        return new ResponseEntity<>(updateUtilisateur, HttpStatus.OK);
    }

    @GetMapping("/find/{login}")
    public ResponseEntity<Utilisateur> getUtilisateurByLogin (@PathVariable("login") String login) {
        Utilisateur utilisateur = utilisateurService.findUtilisateurByLogin(login);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    @PostMapping("/employee/addtoutilisateur")
    public ResponseEntity<?> addEmpToUtilisateur(@RequestBody EmpToUtilisateurForm form){
        utilisateurService.addEmpToUtilisateur(form.getIdemp(),form.getIdU());
        return ResponseEntity.ok().build();
    }
    @PostMapping("/profil/addtoutilisateur")
    public ResponseEntity<?> addProfilToUtilisateur(@RequestBody ProfilToUtilisateurForm form){
        utilisateurService.addProfilToUtilisateur(form.getIdprofil(),form.getIdU());
        return ResponseEntity.ok().build();
    }
}
class EmpToUtilisateurForm {
    private Long idemp;
    private Long idU;

    public Long getIdemp() {
        return idemp;
    }

    public void setIdemp(Long idemp) {
        this.idemp = idemp;
    }

    public Long getIdU() {
        return idU;
    }

    public void setIdU(Long idU) {
        this.idU = idU;
    }
}
class ProfilToUtilisateurForm {
    private Long idprofil;
    private Long idU;

    public Long getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(Long idprofil) {
        this.idprofil = idprofil;
    }

    public Long getIdU() {
        return idU;
    }

    public void setIdU(Long idU) {
        this.idU = idU;
    }
}

