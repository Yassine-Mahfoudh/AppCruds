package com.example.myapp.Utilisateur;

import com.example.myapp.Fonctionalite.Fonctionalite;
import com.example.myapp.Profil.Profil;
import com.example.myapp.employee.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table
public class Utilisateur {
    @Id
    @SequenceGenerator(
            name = "utilisateur_sequence",
            sequenceName ="utilisateur_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "utilisateur_sequence"
    )
    private Long id;
    private String login;
    private String MotDePasse;
    private String email;
    @OneToOne
    @JoinColumn(name = "employee_fk",referencedColumnName = "id")
    private Employee employee;
//    @ManyToMany(fetch = EAGER )
//    private Collection<Profil> profils = new ArrayList<>();

    public Utilisateur() {
    }

    public Utilisateur(Long id, String login, String motDePasse, String email) {
        this.id = id;
        this.login = login;
        MotDePasse = motDePasse;
        this.email = email;
    }

    public Utilisateur(String login, String motDePasse, String email ) {
        this.login = login;
        MotDePasse = motDePasse;
        this.email = email;
    }

//    public Collection<Profil> getProfils() {
//        return profils;
//    }

//    public void setProfils(Collection<Profil> profils) {
//        this.profils = profils;
//    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        MotDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", MotDePasse='" + MotDePasse + '\'' +
                ", email='" + email + '\'' +
                ", employee=" + employee +
                '}';
    }
}

