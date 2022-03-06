package com.example.myapp.salle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/salle")
public class SalleController {
    private final SalleService salleService;
    @Autowired
    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public List<Salle> getSalle() {
        return salleService.getSalle();
    }

    @PostMapping("/add")
    public ResponseEntity<Salle> addSalle(@RequestBody Salle salle){
        Salle newSalle = salleService.addNewSalle(salle);
        return new ResponseEntity<>(newSalle, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{num}")
    public ResponseEntity<?> deleteSalle(@PathVariable("num") int num) {
        salleService.deleteSalle(num);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Salle> updateSalle(@RequestBody Salle salle) {
        Salle updateSalle = salleService.updateSalle(salle);
        return new ResponseEntity<>(updateSalle, HttpStatus.OK);
    }

   @GetMapping("/find/{num}")
    public ResponseEntity<Salle> getSalleByNum (@PathVariable("num") int num) {
        Salle salle = salleService.findSalleByNum(num);
        return new ResponseEntity<>(salle, HttpStatus.OK);
    }

}