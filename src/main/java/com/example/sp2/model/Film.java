package com.example.sp2.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="film")
@Getter
@Setter
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer Id;

    private String titre;

    private String description;

    private String affiche;

     Genre genre;

    public Film() {

    }
}
