//package com.example.myapp.TypeDemande;
//
//
//import com.example.myapp.persistence.model.Demande;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.Set;
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table
//public class TypeDemande {
//    @Id
//    @SequenceGenerator(
//            name = "typeDemande_sequence",
//            sequenceName ="typeDemande_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "typeDemande_sequence"
//    )
//    private Long id;
//    private String type;
//
//    @OneToMany
//    @JoinColumn(name = "type_id")
//    private Set<Demande> demandes;
//
//    public TypeDemande(String type) {
//        this.type = type;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    @Override
//    public String toString() {
//        return "LogAccess{" +
//                "id=" + id +
//                ", type='" + type + '\'' +
//                '}';
//    }
//}
