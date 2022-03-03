package com.example.myapp.Profil;

import com.example.myapp.Utilisateur.Utilisateur;
import com.example.myapp.Utilisateur.UtilisateurService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/profil")
public class ProfilController{
    private final ProfilService profilService;
    @Autowired
    public ProfilController(ProfilService profilService) {

        this.profilService =  profilService;
    }

        @GetMapping
        public List<Profil> getProfils() {
            return profilService.getProfils();
        }

//        @PostMapping("/add")
//        public ResponseEntity<Profil> addProfil(@RequestBody Profil profil){
//            Profil newProfil=profilService.addNewProfil(profil);
//            return new ResponseEntity<>(newProfil , HttpStatus.CREATED);
//        }
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteProfil(@PathVariable("id") Long id) {
            profilService.deleteProfil(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        @PutMapping("/update")
        public ResponseEntity<Profil> updateProfil(@RequestBody Profil profil) {
            Profil updateProfil = profilService.updateProfil(profil);
            return new ResponseEntity<>(updateProfil, HttpStatus.OK);
        }

        @GetMapping("/find/{id}")
        public ResponseEntity<Profil> getProfilById (@PathVariable("id") Long id) {
            Profil profil = profilService.findProfilById(id);
            return new ResponseEntity<>(profil, HttpStatus.OK);
        }

    @PostMapping("/fonctionalite/addtoprofil")
    public ResponseEntity<?> addFonctionaliteToProfil(@RequestBody FoncToUserForm form){
        profilService.addFoncToProfil(form.getProfilType(),form.getFoncnom());
        return ResponseEntity.ok().build();
    }

}

class FoncToUserForm{
    private String profilType;
    private String foncnom;

    public FoncToUserForm(String profilType, String foncnom) {
        this.profilType = profilType;
        this.foncnom = foncnom;
    }

    public String getProfilType() {
        return profilType;
    }

    public void setProfilType(String profilType) {
        this.profilType = profilType;
    }

    public String getFoncnom() {
        return foncnom;
    }

    public void setFoncnom(String foncnom) {
        this.foncnom = foncnom;
    }
}