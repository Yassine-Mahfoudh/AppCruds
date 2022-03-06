package com.example.myapp.Projet;



import com.example.myapp.employee.Employee;
import com.example.myapp.salle.Salle;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Projet {
    @Id
    @SequenceGenerator(
            name = "projet_sequence",
            sequenceName ="projet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "projet_sequence"
    )
    private Long id;
    private String nom;
    private int priorite;
    private String description;
    private LocalDate datedebut;
    private LocalDate datefin;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "projet_id")
    private Set<Employee> employees;

    public Projet(Long id, String nom, int priorite, String description, LocalDate datedebut, LocalDate datefin) {
        this.id = id;
        this.nom = nom;
        this.priorite = priorite;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Projet(String nom, int priorite, String description, LocalDate datedebut, LocalDate datefin) {
        this.nom = nom;
        this.priorite = priorite;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Projet() {
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
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

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", priorite=" + priorite +
                ", description='" + description + '\'' +
                ", datedebut=" + datedebut +
                ", datefin=" + datefin +
                '}';
    }
}
