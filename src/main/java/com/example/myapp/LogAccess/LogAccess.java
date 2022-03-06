package com.example.myapp.LogAccess;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class LogAccess {
    @Id
    @SequenceGenerator(
            name = "logAccess_sequence",
            sequenceName ="logAccess_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "logAccess_sequence"
    )
    private Long id;
    private LocalDate date;
    private String heureentree;
    private String heuresortie;

    public LogAccess(Long id, LocalDate date, String heureentree, String heuresortie) {
        this.id = id;
        this.date = date;
        this.heureentree = heureentree;
        this.heuresortie = heuresortie;
    }

    public LogAccess(LocalDate date, String heureentree, String heuresortie) {
        this.date = date;
        this.heureentree = heureentree;
        this.heuresortie = heuresortie;
    }

    public LogAccess() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHeureentree() {
        return heureentree;
    }

    public void setHeureentree(String heureentree) {
        this.heureentree = heureentree;
    }

    public String getHeuresortie() {
        return heuresortie;
    }

    public void setHeuresortie(String heuresortie) {
        this.heuresortie = heuresortie;
    }

    @Override
    public String toString() {
        return "LogAccess{" +
                "id=" + id +
                ", date=" + date +
                ", heureentree='" + heureentree + '\'' +
                ", heuresortie='" + heuresortie + '\'' +
                '}';
    }
}
