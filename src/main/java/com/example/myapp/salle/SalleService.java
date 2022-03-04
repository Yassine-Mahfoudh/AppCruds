package com.example.myapp.salle;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SalleService {
    public final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<Salle> getSalle(){
        return salleRepository.findAll();
    }

//    public Salle addNewSalle(Salle Salle) {
//        Optional<Salle> SalleOptional = salleRepository
//                .findSalleByNum(Salle.getNum());
//        if (SalleOptional.isPresent()){
//            throw new IllegalStateException("nom token");
//        }
//        return salleRepository.save(Salle);
//    }
    public void deleteSalle(Long id){
        salleRepository.findById(id);
        boolean exists= salleRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "salle with id "+ id + " does not exists");
        }
        salleRepository.deleteById(id);
    }
    @Transactional
    public Salle updateSalle(Salle Salle) {

        return salleRepository.save(Salle);
    }

    public Salle findSalleById(Long id) {
        return salleRepository.findSalleById(id)
                .orElseThrow(() -> new IllegalStateException(" salle with id " + id + " does not exists"));
    }
}
