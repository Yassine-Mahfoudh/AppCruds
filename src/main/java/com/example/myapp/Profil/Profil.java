package com.example.myapp.Profil;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return "Profil{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public Profil(String type) {
        this.type = type;
    }

    public Profil(Long id, String type) {
        this.id = id;
        this.type = type;
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
