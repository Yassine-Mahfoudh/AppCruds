package com.example.myapp.Projet;


import com.example.myapp.employee.Employee;
import com.example.myapp.salle.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/projet")
public class ProjetController {
    private final ProjetService projetService;
@Autowired
    public ProjetController(ProjetService projetService) {
        this.projetService =  projetService;
    }

    @GetMapping
    public List<Projet> getProjet() { return projetService.getProjet();}

    @PostMapping("/add")
    public ResponseEntity<Projet> addProjet(@RequestBody Projet projet){
        Projet newProjet=projetService.addNewProjet(projet);
        return new ResponseEntity<>(newProjet ,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{nom}")
    public ResponseEntity<?> deleteProjet(@PathVariable("nom") String nom) {
        projetService.deleteProjet(nom);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet projet) {
        Projet updateProjet = projetService.updateProjet(projet);
        return new ResponseEntity<>(updateProjet, HttpStatus.OK);
    }

    @GetMapping("/find/{nom}")
    public ResponseEntity<Projet> getProjetByNom (@PathVariable("nom") String nom) {
        Projet projet = projetService.findProjetByNom(nom);
        return new ResponseEntity<>(projet, HttpStatus.OK);
    }

    @GetMapping("/find/{nom}/employees")
    public List<Employee> getEmpbyProjet(@PathVariable("nom") String nom) {
        return projetService.getEmpByProjet(nom); }

    @PostMapping("/emp/addtoprojet")
    public ResponseEntity<?> addEmpToProjet(@RequestBody EmpToProjetForm form){
        projetService.addEmpToProjet(form.getIdprojet(),form.getIdemp());
        return ResponseEntity.ok().build();
    }

}
class EmpToProjetForm{
    private Long idprojet;
    private Long idemp;

    public Long getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(Long idprojet) {
        this.idprojet = idprojet;
    }

    public Long getIdemp() {
        return idemp;
    }

    public void setIdemp(Long idemp) {
        this.idemp = idemp;
    }
}