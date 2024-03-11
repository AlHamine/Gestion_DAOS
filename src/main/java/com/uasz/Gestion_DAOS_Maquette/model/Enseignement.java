package com.uasz.Gestion_DAOS_Maquette.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String description;
    @ManyToOne
    private Module module;
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private Groupe groupe;
    //     @OneToMany
    // private List<Repartition> repartition;
}
