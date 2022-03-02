package com.example.myapp.LogFonctionalite;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table
public class LogFonc {
    @Id
    @SequenceGenerator(
            name = "logfonc_sequence",
            sequenceName ="logfonc_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "logfonc_sequence"
    )
    private Long id;
    private LocalDate date;
    private LocalTime hdebut;
    private LocalTime hfin;

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

    public LocalTime getHdebut() {
        return hdebut;
    }

    public void setHdebut(LocalTime hdebut) {
        this.hdebut = hdebut;
    }

    public LocalTime getHfin() {
        return hfin;
    }

    public void setHfin(LocalTime hfin) {
        this.hfin = hfin;
    }

    public LogFonc() {
    }

    public LogFonc(LocalDate date, LocalTime hdebut, LocalTime hfin) {
        this.date = date;
        this.hdebut = hdebut;
        this.hfin = hfin;
    }

    public LogFonc(Long id, LocalDate date, LocalTime hdebut, LocalTime hfin) {
        this.id = id;
        this.date = date;
        this.hdebut = hdebut;
        this.hfin = hfin;
    }
}
