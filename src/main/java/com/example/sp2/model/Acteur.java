package com.example.sp2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="acteur")
@Getter
@Setter
@AllArgsConstructor
public class Acteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,unique=true)
    private Integer Id_acteur;

    private String nom;

    private String prenom;

    private String photo;


    public Acteur() {}


}
