package com.uasz.Gestion_DAOS_EmploiDuTemps.RepartitionService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.uasz.Gestion_DAOS_EmploiDuTemps.Maquette_Service.Model.Enseignement;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Seance;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @ManyToOne
    // private Enseignement enseignement;
    // @ManyToOne
    // private Enseignant enseignant;
    private String libelle;
    private String description;
    private Long idModule;
    private Long module;
    private String cours;
    private int coefficient;
    private int nbreHeure;
    private Long idClasse;
    private String classe;
    private Long idGroupe;
    private String groupe;
    private Long enseignatId;
    private String nom;
    private String prenom;
    private String grade;
    private String matricule;
    private String specialite;
    @OneToMany(mappedBy = "repartition")
    private List<Seance> seances;
}