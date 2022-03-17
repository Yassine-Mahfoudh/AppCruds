//package com.example.myapp.EtatDemande;
//
//import com.example.myapp.salle.Salle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping(path = "/etatdemande")
//public class EtatDemandeController {
//    private final EtatDemandeService etatDemandeService;
//    @Autowired
//    public EtatDemandeController(EtatDemandeService etatDemandeService) {
//        this.etatDemandeService = etatDemandeService;
//    }
//
//    @GetMapping
//    public List<EtatDemande> getEtatDemande() {
//        return etatDemandeService.getEtatDemande();
//    }
//
//    @GetMapping("/find/{id}")
//    public ResponseEntity<EtatDemande> getEtatByStatut (@PathVariable("id") Long id) {
//        EtatDemande etatDemande = etatDemandeService.findEtatDemandeById(id);
//        return new ResponseEntity<>(etatDemande, HttpStatus.OK);
//    }
//}
