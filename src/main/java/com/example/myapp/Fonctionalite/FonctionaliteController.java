package com.example.myapp.Fonctionalite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/fonctionalite")
public class FonctionaliteController {
    private final FonctionaliteService fonctionaliteService;
    @Autowired
    public FonctionaliteController(FonctionaliteService fonctionaliteService) {
        this.fonctionaliteService =  fonctionaliteService;
    }

    @GetMapping
    public List<Fonctionalite> getFonctionalites() {
        return fonctionaliteService.getFonctionalites();
    }

//    @PostMapping("/add")
//    public ResponseEntity<Fonctionalite> addFonctionalite(@RequestBody Fonctionalite fonctionalite){
//        Fonctionalite newFonctionalite=fonctionaliteService.addNewFonctionalite(fonctionalite);
//        return new ResponseEntity<>(newFonctionalite , HttpStatus.CREATED);
//    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFonctionalite(@PathVariable("id") Long id) {
        fonctionaliteService.deleteFonctionalite(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Fonctionalite> updateFonctionalite(@RequestBody Fonctionalite fonctionalite) {
        Fonctionalite updateFonctionalite = fonctionaliteService.updateFonctionalite(fonctionalite);
        return new ResponseEntity<>(updateFonctionalite, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Fonctionalite> getFonctionaliteById (@PathVariable("id") Long id) {
        Fonctionalite fonctionalite = fonctionaliteService.findFonctionaliteById(id);
        return new ResponseEntity<>(fonctionalite, HttpStatus.OK);
    }
}
