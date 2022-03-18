//package com.example.myapp.Departement;
//
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//
//@Entity
//@Table
//public class Departement implements Serializable {
//    @Id
//    @SequenceGenerator(
//            name = "departement_sequence",
//            sequenceName ="departement_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "departement_sequence"
//    )
//    private Long id;
//    private String nom;
//    private int nbsalles;
//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY)
//    @JoinColumn(name = "dep_id")
//    private Set<Salle> Salles;
//
//    public Departement(String nom, int nbsalles) {
//        this.nom = nom;
//        this.nbsalles = nbsalles;
//    }
//
//    public Departement(Long id, String nom, int nbsalles) {
//        this.id = id;
//        this.nom = nom;
//        this.nbsalles = nbsalles;
//    }
//
//    public Departement() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public int getNbsalles() {
//        return nbsalles;
//    }
//
//    public void setNbsalles(int nbsalles) {
//        this.nbsalles = nbsalles;
//    }
//
//    public Set<Salle> getSalles() {
//        return Salles;
//    }
//
//    public void setSalles(Set<Salle> salles) {
//        Salles = salles;
//    }
//
//    @Override
//    public String toString() {
//        return "Departement{" +
//                "id=" + id +
//                ", nom='" + nom + '\'' +
//                ", nbsalles=" + nbsalles +
//                '}';
//    }
//}
