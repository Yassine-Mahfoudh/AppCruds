package com.example.myapp.employee;



import com.example.myapp.Utilisateur.Utilisateur;
import com.example.myapp.persistence.model.Demande;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName ="employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String nom;
    private String prenom;
    private String role;
    private Boolean etat;
    private LocalDate datenaiss;
    private String adresse;
    @OneToOne(mappedBy = "employee")
    private Utilisateur utilisateur;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Set<Demande> demandes;

    public Employee(Long id, String nom, String prenom,
                    LocalDate datenaiss, String adresse, String role,Boolean etat ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.adresse = adresse;
        this.role=role;
        this.etat=etat;
    }
    public Employee() {
    }
    public Employee(String nom, String prenom,LocalDate datenaiss,String adresse, String role,Boolean etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.datenaiss = datenaiss;
        this.adresse = adresse;
        this.etat=etat;

    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(LocalDate datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Set<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(Set<Demande> demandes) {
        this.demandes = demandes;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", datenaiss=" + datenaiss +
                ", adresse='" + adresse + '\'' +
                ", etat='"+etat+
                '}';
    }
}
