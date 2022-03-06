package com.example.myapp.Departement;

        import com.example.myapp.salle.Salle;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;


@RestController
@RequestMapping(path = "/departement")
public class DepartementController {
    private final DepartementService departementService;
    @Autowired
    public DepartementController(DepartementService departementService) {
        this.departementService =  departementService;
    }

    @GetMapping
    public List<Departement> getDepartement() {
        return departementService.getDepartement();
    }

    @PostMapping("/add")
    public ResponseEntity<Departement> addDepartement(@RequestBody Departement departement){
        Departement newDepartement=departementService.addNewDepartement(departement);
        return new ResponseEntity<>(newDepartement , HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{nom}")
    public ResponseEntity<?> deleteDepartement(@PathVariable("nom") String nom) {
        departementService.deleteDepartement(nom);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Departement> updateDepartement(@RequestBody Departement departement) {
        Departement updateDepartement = departementService.updateDepartement(departement);
        return new ResponseEntity<>(updateDepartement, HttpStatus.OK);
    }

    @GetMapping("/find/{nom}")
    public ResponseEntity<Departement> getDepartementByNom (@PathVariable("nom") String nom) {
        Departement departement = departementService.findDepartementByNom(nom);
        return new ResponseEntity<>(departement, HttpStatus.OK);
    }

    @GetMapping("/find/{id}/salles")
    public List<Salle> getSallebyDepartement(@PathVariable("id") Long id) {
        return departementService.getSallebyDepartement(id); }
    @PostMapping("/salle/addtodep")
    public ResponseEntity<?> addSalleToDepartement(@RequestBody SalleToDepartForm form){
        departementService.addSalleToDep(form.getIddep(),form.getIdsalle());
        return ResponseEntity.ok().build();
    }

}
class SalleToDepartForm{
    private Long iddep;
    private Long idsalle;

    public SalleToDepartForm(Long iddep, Long idsalle) {
        this.iddep = iddep;
        this.idsalle = idsalle;
    }

    public Long getIddep() {
        return iddep;
    }

    public void setIddep(Long iddep) {
        this.iddep = iddep;
    }

    public Long getIdsalle() {
        return idsalle;
    }

    public void setIdsalle(Long idsalle) {
        this.idsalle = idsalle;
    }
}
