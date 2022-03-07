package com.example.myapp.TypeDemande;

import com.example.myapp.EtatDemande.EtatDemande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/typedemande")
public class TypeDemandeController {
    private final TypeDemandeService typeDemandeService;
    @Autowired
    public TypeDemandeController(TypeDemandeService typeDemandeService) {
        this.typeDemandeService =  typeDemandeService;
    }

    @GetMapping
    public List<TypeDemande> getTypeDemande() {
        return typeDemandeService.getTypeDemande();
    }



    @GetMapping("/find/{id}")
    public ResponseEntity<TypeDemande> getTypeById (@PathVariable("id") Long id) {
        TypeDemande typeDemande = typeDemandeService.findTypeDemandeById(id);
        return new ResponseEntity<>(typeDemande, HttpStatus.OK);
    }


}
