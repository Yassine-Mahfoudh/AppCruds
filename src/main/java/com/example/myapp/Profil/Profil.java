package com.example.myapp.Profil;

import com.example.myapp.Fonctionalite.Fonctionalite;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table
public class Profil {
    @Id
    @SequenceGenerator(
            name = "profil_sequence",
            sequenceName ="profil_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profil_sequence"
    )
    private Long id;
    private String type;
    private LocalDate date_creation;
    @ManyToMany(fetch = EAGER )
    private Collection<Fonctionalite> fonctionalites = new ArrayList<>();

    public Profil(String type, LocalDate date_creation, Collection<Fonctionalite> fonctionalites) {
        this.type = type;
        this.date_creation = date_creation;
        this.fonctionalites = fonctionalites;
    }

    public Profil(Long id, String type, LocalDate date_creation, Collection<Fonctionalite> fonctionalites) {
        this.id = id;
        this.type = type;
        this.date_creation = date_creation;
        this.fonctionalites = fonctionalites;
    }

    public Collection<Fonctionalite> getFonctionalites() {
        return fonctionalites;
    }

    public void setFonctionalites(Collection<Fonctionalite> fonctionalites) {
        this.fonctionalites = fonctionalites;
    }

    public LocalDate getDate_creation() {
        return date_creation;
    }


    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Profil() {
    }
}
