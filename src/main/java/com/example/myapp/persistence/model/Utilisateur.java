package com.example.myapp.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Utilisateur {
    @SequenceGenerator(
            name = "utilisateur_sequence",
            sequenceName ="utilisateur_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "utilisateur_sequence"
    )
    @Id
    @Column(name="ID_UTILISATEUR", unique = true, nullable = false)
    private Long id;
    @Column(name = "LOGIN", unique = true, nullable = false, length = 50)
    private String login;
    @Column(name = "MOTDEPASSE", nullable = false)
    private String motdepasse;
    @Column(name = "EMAIL")
    private String email;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "DATE_CREATION")
    private Timestamp datecreation;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "DATE_UPDATE")
    private Timestamp dateupdate;

    @OneToOne
    @JoinColumn(name = "ID_EMP")
    private Employee employee;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Profil> profils = new ArrayList<>();

    public Utilisateur(String login, String motdepasse, String email) {
        this.login = login;
        this.motdepasse = motdepasse;
        this.email = email;
    }
}
