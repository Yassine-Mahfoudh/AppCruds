package com.example.myapp.Fonctionalite;



import javax.persistence.*;

@Entity
@Table
public class Fonctionalite {
    @Id
    @SequenceGenerator(
            name = "fonctionalite_sequence",
            sequenceName ="fonctionalite_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fonctionalite_sequence"
    )
    private Long id;
    private String nom;
    private String designation;

    public Fonctionalite(String nom, String designation) {
        this.nom = nom;
        this.designation = designation;
    }

    public Fonctionalite(Long id, String nom, String designation) {
        this.id = id;
        this.nom = nom;
        this.designation = designation;
    }

    public Fonctionalite() {
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Fonctionalite{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
