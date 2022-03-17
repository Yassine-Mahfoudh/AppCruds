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
public class EtatDemande {

    @Id
    @SequenceGenerator(
            name = "etatDemande_sequence",
            sequenceName ="etatDemande_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "etatDemande_sequence"
    )
    private Long id;
    private String statut;

    @OneToMany
    @  JoinColumn(name = "etat_id", insertable = false, updatable = false)
    private Set<Demande> demandes;

    public EtatDemande(String statut) {
        this.statut = statut;
    }


}
