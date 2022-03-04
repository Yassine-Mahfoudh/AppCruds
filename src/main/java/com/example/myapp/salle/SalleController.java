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

//    @PostMapping("/add")
//    public ResponseEntity<Salle> addSalle(@RequestBody Salle salle){
//        Salle newSalle = salleService.addNewSalle(salle);
//        return new ResponseEntity<>(newSalle, HttpStatus.CREATED);
//    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSalle(@PathVariable("id") Long id) {
        salleService.deleteSalle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Salle> updateSalle(@RequestBody Salle salle) {
        Salle updateSalle = salleService.updateSalle(salle);
        return new ResponseEntity<>(updateSalle, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Salle> getSalleById (@PathVariable("id") Long id) {
        Salle salle = salleService.findSalleById(id);
        return new ResponseEntity<>(salle, HttpStatus.OK);
    }

    /*@PutMapping(path = "{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String adresse){
        employeeService.updateEmployee(id,nom,adresse);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
