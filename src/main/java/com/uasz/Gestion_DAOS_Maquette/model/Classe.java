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
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private int effectif;
    private int nbreGroupe;
    private String description;
    @OneToMany(mappedBy = "classe")
    private List<Enseignement> enseignement;
    @ManyToOne
    private Semestre semestre;
    @OneToMany(mappedBy = "classe")
    private List<Groupe> groupes;
    @ManyToOne
    private Formation formation;
}
