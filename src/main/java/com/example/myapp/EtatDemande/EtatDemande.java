package com.example.myapp.EtatDemande;

import javax.persistence.*;

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

    public EtatDemande(Long id, String statut) {
        this.id = id;
        this.statut = statut;
    }

    public EtatDemande() {
    }

    public EtatDemande(String statut) {
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "LogAccess{" +
                "id=" + id +
                ", statut='" + statut + '\'' +
                '}';
    }
}
