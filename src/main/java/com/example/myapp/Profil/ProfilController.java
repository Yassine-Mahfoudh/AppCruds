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
        @DeleteMapping("/delete/{type}")
        public ResponseEntity<?> deleteProfil(@PathVariable("type") String type) {
            profilService.deleteProfil(type);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        @PutMapping("/update")
        public ResponseEntity<Profil> updateProfil(@RequestBody Profil profil) {
            Profil updateProfil = profilService.updateProfil(profil);
            return new ResponseEntity<>(updateProfil, HttpStatus.OK);
        }

        @GetMapping("/find/{type}")
        public ResponseEntity<Profil> getProfilByType (@PathVariable("type") String type) {
            Profil profil = profilService.findProfilByType(type);
            return new ResponseEntity<>(profil, HttpStatus.OK);
        }

    @PostMapping("/fonctionalite/addtoprofil")
    public ResponseEntity<?> addFonctionaliteToProfil(@RequestBody FoncToUserForm form){
        profilService.addFoncToProfil(form.getIdprofil(),form.getIdfonc());
        return ResponseEntity.ok().build();
    }

}

class FoncToUserForm{
    private Long idprofil;
    private Long idfonc;

    public Long getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(Long idprofil) {
        this.idprofil = idprofil;
    }

    public Long getIdfonc() {
        return idfonc;
    }

    public void setIdfonc(Long idfonc) {
        this.idfonc = idfonc;
    }
}