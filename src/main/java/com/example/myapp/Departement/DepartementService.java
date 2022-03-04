package com.example.myapp.Departement;

        import com.example.myapp.salle.Salle;
        import com.example.myapp.salle.SalleRepository;
        import org.springframework.stereotype.Service;

        import javax.transaction.Transactional;
        import java.util.List;
        import java.util.Optional;

@Service
public class DepartementService {
    public final DepartementRepository departementRepository;
    public final SalleRepository salleRepository;
    public DepartementService(DepartementRepository departementRepository, SalleRepository salleRepository) {
        this.departementRepository = departementRepository;
        this.salleRepository = salleRepository;
    }



    public List<Departement> getDepartement(){
        return departementRepository.findAll();
    }

//    public Departement addNewDepartement(Departement departement) {
//        Optional<Departement> departementOptional = departementRepository
//                .findDepartementByNom(departement.getNom());
//        if (departementOptional.isPresent()){
//            throw new IllegalStateException("nom token");
//        }
//        return departementRepository.save(departement);
//    }
    public void deleteDepartement(Long id){
        departementRepository.findById(id);
        boolean exists=departementRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "departement with id "+ id + " does not exists");
        }
        departementRepository.deleteById(id);
    }
    @Transactional
    public Departement updateDepartement(Departement departement) {

        return departementRepository.save(departement);
    }

    public Departement findDepartementById(Long id) {
        return departementRepository.findDepartementById(id)
                .orElseThrow(() -> new IllegalStateException("User by id " + id + " was not found"));
    }

    public List<Salle> getSallebyDepartement(Long id) {
        return departementRepository.getSallebyDepartement(id);
    }

    public void addSalleToDep(String nomdep, int numsalle) {
        Departement departement = departementRepository.findDepartementByNom(nomdep);
        Salle salle = salleRepository.findSalleByNum(numsalle);
        departement.getSalles().add(salle);
        departementRepository.save(departement);
    }
}
