package com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Model.Seance;
import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Model.Enseignement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition_Emploi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private String semestre;
    private String nom;
    private String prenom;
    private String grade;
}
