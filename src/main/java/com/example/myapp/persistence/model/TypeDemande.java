package com.example.myapp.persistence.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class TypeDemande {
    @Id
    @SequenceGenerator(
            name = "typeDemande_sequence",
            sequenceName ="typeDemande_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "typeDemande_sequence"
    )
    private Long id;
    private String type;
    @OneToMany
@   JoinColumn(name = "type_id", insertable = false, updatable = false)
    private Set<Demande> demandes;

    public TypeDemande(String type) {
        this.type = type;
    }


}
