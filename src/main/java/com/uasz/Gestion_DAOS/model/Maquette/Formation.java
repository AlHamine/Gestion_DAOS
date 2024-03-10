package com.uasz.Gestion_DAOS.model.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    private Filiere filiere;
    @OneToOne
    private Maquette maquette;
    @JsonIgnore
    @OneToMany(mappedBy = "formation")
    private List<Classe> classes;
    @ManyToOne
    private Niveau niveau;
    private Date createdAt = new Date();
}
