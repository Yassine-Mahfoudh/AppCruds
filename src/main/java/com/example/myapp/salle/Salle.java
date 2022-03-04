package com.example.myapp.salle;

import com.example.myapp.Departement.Departement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Salle implements Serializable {
    @Id
    @SequenceGenerator(
            name = "salle_sequence",
            sequenceName ="salle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "salle_sequence"
    )
    private Long id;
    private String type;
    private int num;
    private int nbposte;
    private int pourcentagePres;


    public Salle(String type, int num, int nbposte, int pourcentagePres) {
        this.type = type;
        this.num = num;
        this.nbposte = nbposte;
        this.pourcentagePres = pourcentagePres;
    }

    public Salle(Long id, String type, int num, int nbposte, int pourcentagePres) {
        this.id = id;
        this.type = type;
        this.num = num;
        this.nbposte = nbposte;
        this.pourcentagePres = pourcentagePres;
    }

    public Salle() {
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNbposte() {
        return nbposte;
    }

    public void setNbposte(int nbposte) {
        this.nbposte = nbposte;
    }

    public int getPourcentagePres() {
        return pourcentagePres;
    }

    public void setPourcentagePres(int pourcentagePres) {
        this.pourcentagePres = pourcentagePres;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", num=" + num +
                ", nbposte=" + nbposte +
                ", pourcentagePres=" + pourcentagePres +
                '}';
    }
}
