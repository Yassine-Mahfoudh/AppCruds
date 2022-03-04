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

//    @PostMapping("/add")
//    public ResponseEntity<Departement> addDepartement(@RequestBody Departement departement){
//        Departement newDepartement=departementService.addNewDepartement(departement);
//        return new ResponseEntity<>(newDepartement , HttpStatus.CREATED);
//    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartement(@PathVariable("id") Long id) {
        departementService.deleteDepartement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Departement> updateDepartement(@RequestBody Departement departement) {
        Departement updateDepartement = departementService.updateDepartement(departement);
        return new ResponseEntity<>(updateDepartement, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Departement> getDepartementById (@PathVariable("id") Long id) {
        Departement departement = departementService.findDepartementById(id);
        return new ResponseEntity<>(departement, HttpStatus.OK);
    }

    @GetMapping("/find/{id}/salles")
    public List<Salle> getSallebyDepartement(@PathVariable("id") Long id) {
        return departementService.getSallebyDepartement(id); }
    @PostMapping("/salle/addtodep")
    public ResponseEntity<?> addSalleToDepartement(@RequestBody SalleToDepartForm form){
        departementService.addSalleToDep(form.getNomdep(),form.getNumsalle());
        return ResponseEntity.ok().build();
    }

}
class SalleToDepartForm{
    private String nomdep;
    private int numsalle;

    public SalleToDepartForm(String nomdep, int numsalle) {
        this.nomdep = nomdep;
        this.numsalle = numsalle;
    }

    public String getNomdep() {
        return nomdep;
    }

    public void setNomdep(String nomdep) {
        this.nomdep = nomdep;
    }

    public int getNumsalle() {
        return numsalle;
    }

    public void setNumsalle(int numsalle) {
        this.numsalle = numsalle;
    }
}
