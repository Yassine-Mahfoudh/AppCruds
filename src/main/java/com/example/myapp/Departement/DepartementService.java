//package com.example.myapp.Departement;
//
//        import com.example.myapp.salle.Salle;
//        import com.example.myapp.salle.SalleRepository;
//        import org.springframework.stereotype.Service;
//
//        import javax.transaction.Transactional;
//        import java.util.List;
//        import java.util.Optional;
//
//@Service
//public class DepartementService {
//    public final DepartementRepository departementRepository;
//    public final SalleRepository salleRepository;
//    public DepartementService(DepartementRepository departementRepository, SalleRepository salleRepository) {
//        this.departementRepository = departementRepository;
//        this.salleRepository = salleRepository;
//    }
//
//
//
//    public List<Departement> getDepartement(){
//        return departementRepository.findAll();
//    }
//
//    public Departement addNewDepartement(Departement departement) {
//        Optional<Departement> departementOptional = departementRepository
//                .findDepartementByNom(departement.getNom());
//        if (departementOptional.isPresent()){
//            throw new IllegalStateException("nom token");
//        }
//        return departementRepository.save(departement);
//    }
//    @Transactional
//    public void deleteDepartement(String nom){
//        departementRepository.findDepartementByNom(nom);
//        boolean exists=departementRepository.existsByNom(nom);
//        if (!exists){
//            throw new IllegalStateException(
//                    "departement with name "+ nom + " does not exists");
//        }
//        departementRepository.deleteByNom(nom);
//    }
//    @Transactional
//    public Departement updateDepartement(Departement departement) {
//
//        return departementRepository.save(departement);
//    }
//
//    public Departement findDepartementByNom(String nom) {
//        return departementRepository.findDepartementByNom(nom)
//               .orElseThrow(() -> new IllegalStateException("Departemet by name " + nom + " was not found"));
//    }
//
//    public List<Salle> getSallebyDepartement(String nom) {
//
//        return departementRepository.getSallebyDepartement(nom);
//    }
//
//    public void addSalleToDep(Long iddep, Long idsalle) {
//        Departement departement = departementRepository.findDepartementById(iddep);
//        Salle salle = salleRepository.findSalleById(idsalle);
//        departement.getSalles().add(salle);
//        departementRepository.save(departement);
//    }
//}
