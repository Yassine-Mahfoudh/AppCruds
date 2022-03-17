package com.example.myapp.Demande;

import com.example.myapp.EtatDemande.EtatDemande;
import com.example.myapp.TypeDemande.TypeDemande;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Demande implements Serializable {
    @Id
    @SequenceGenerator(
            name = "Demande_sequence",
            sequenceName ="Demande_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Demande_sequence"
    )
    private Long id;
    private String nom;
    private String motif;
    private LocalDate datecreation;
    private LocalDate datedebut;
    private LocalDate datefin;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "dem_id")
    private Set<EtatDemande>  etatDemandes;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "dem_id")
    private Set<TypeDemande>  typeDemandes;


    public Demande(Long id, String nom, String motif, LocalDate datecreation, LocalDate datedebut, LocalDate datefin) {
        this.id = id;
        this.nom = nom;
        this.motif = motif;
        this.datecreation = datecreation;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Demande(String nom, String motif, LocalDate datecreation, LocalDate datedebut, LocalDate datefin) {
        this.nom = nom;
        this.motif = motif;
        this.datecreation = datecreation;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Set<TypeDemande> getTypeDemandes() {
        return typeDemandes;
    }

    public void setTypeDemandes(Set<TypeDemande> typeDemandes) {
        this.typeDemandes = typeDemandes;
    }

    public Set<EtatDemande> getEtatDemandes() {
        return etatDemandes;
    }

    public void setEtatDemandes(Set<EtatDemande> etatDemandes) {
        this.etatDemandes = etatDemandes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public LocalDate getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }

    public LocalDate getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(LocalDate datedebut) {
        this.datedebut = datedebut;
    }

    public LocalDate getDatefin() {
        return datefin;
    }

    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }


    public Demande() {
    }

    @Override
    public String toString() {
        return "Demande{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", motif='" + motif + '\'' +
                ", datecreation=" + datecreation +
                ", datedebut=" + datedebut +
                ", datefin=" + datefin +
                '}';
    }
}
