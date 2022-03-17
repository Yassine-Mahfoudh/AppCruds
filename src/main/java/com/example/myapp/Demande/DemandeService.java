//package com.example.myapp.Demande;
//
//import com.example.myapp.EtatDemande.EtatDemande;
//import com.example.myapp.EtatDemande.EtatDemandeRepository;
//import com.example.myapp.TypeDemande.TypeDemande;
//import com.example.myapp.TypeDemande.TypeDemandeRepository;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DemandeService {
//
//    public final DemandeRepository demandeRepository;
//    public final EtatDemandeRepository etatDemandeRepository;
//    public final TypeDemandeRepository typeDemandeRepository;
//
//    public DemandeService(DemandeRepository demandeRepository, EtatDemandeRepository etatDemandeRepository, TypeDemandeRepository typeDemandeRepository) {
//        this.demandeRepository = demandeRepository;
//        this.etatDemandeRepository =etatDemandeRepository;
//
//        this.typeDemandeRepository = typeDemandeRepository;
//    }
//
//    public List<Demande> getDemande(){
//        return demandeRepository.findAll();
//    }
//
//    public Demande addNewDemande(Demande demande) {
//        Optional<Demande> demandeOptional = demandeRepository
//                .findDemandeByNom(demande.getNom());
//        if (demandeOptional.isPresent()){
//            throw new IllegalStateException("nom token");
//        }
//        return demandeRepository.save(demande);
//    }
//    @Transactional
//    public void deleteDemande(String nom){
//        demandeRepository.findDemandeByNom(nom);
//        boolean exists= demandeRepository.existsByNom(nom);
//        if (!exists){
//            throw new IllegalStateException(
//                    "demande with name "+ nom + " does not exists");
//        }
//        demandeRepository.deleteByNom(nom);
//    }
//    @Transactional
//    public Demande updateDemande(Demande demande) {
//
//        return demandeRepository.save(demande);
//    }
//
//
//    public Demande findDemandeByNom(String nom) {
//        return demandeRepository.findDemandeByNom(nom)
//                .orElseThrow(() -> new IllegalStateException("Demande by name " + nom + " was not found"));
//    }
////    public List<EtatDemande> getEtatbyDemande(Long id) {
////        return demandeRepository.getEtatbyDemande(id);
////
////    }
////
////    public void addEtatToDem(Long iddem, Long idetat) {
////        Demande demande = demandeRepository.findDemandeById(iddem);
////        EtatDemande etatDemande = etatDemandeRepository.findEtatDemandeById(idetat);
////        demande.getEtatDemandes().add(etatDemande);
////        demandeRepository.save(demande);
////    }
//
////    public void addTypeToDemande(Long iddem, Long idtype) {
////        Demande demande = demandeRepository.findDemandeById(iddem);
////        TypeDemande typeDemande = typeDemandeRepository.findTypeDemandeById(idtype);
////        demande.getTypeDemandes().add(typeDemande);
////        demandeRepository.save(demande);
////    }
//
////    public List<TypeDemande> getTypebyDemande(Long id) {
////        return demandeRepository.getTypebyDemande(id);
////    }
//
//
//}
