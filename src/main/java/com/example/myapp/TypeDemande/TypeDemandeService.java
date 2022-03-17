package com.example.myapp.TypeDemande;


import com.example.myapp.persistence.model.TypeDemande;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeDemandeService {
    public final TypeDemandeRepository typeDemandeRepository;
    public TypeDemandeService(TypeDemandeRepository typeDemandeRepository ) {
        this.typeDemandeRepository = typeDemandeRepository;
    }


    public List<TypeDemande> getTypeDemande() {
        return typeDemandeRepository.findAll();
    }


    public TypeDemande findTypeDemandeById(Long id) {
        return typeDemandeRepository.findTypeDemandeById(id);
    }}