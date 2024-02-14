package com.uasz.Gestion_DAOS_Maquette.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @OneToMany(mappedBy = "formation")
    private List<Classe> classes;
    @ManyToOne
    private Niveau niveau;
}
