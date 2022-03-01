package com.example.myapp.Utilisateur;

import com.example.myapp.employee.Employee;

import javax.persistence.*;

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
    @JoinColumn(name = "employee_fk")
    private Employee employee;

    public Utilisateur() {
    }

    public Utilisateur(String login, String motDePasse, String email) {
        this.login = login;
        MotDePasse = motDePasse;
        this.email = email;
    }

    public Utilisateur(Long id, String login, String motDePasse, String email) {
        this.id = id;
        this.login = login;
        this.MotDePasse = motDePasse;
        this.email = email;

    }

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
