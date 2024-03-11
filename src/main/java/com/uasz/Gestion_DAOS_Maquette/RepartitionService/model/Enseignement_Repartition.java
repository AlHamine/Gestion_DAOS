package com.uasz.Gestion_DAOS_Maquette.RepartitionService.model;

import java.util.List;

import com.uasz.Gestion_DAOS_Maquette.model.Classe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Enseignement_Repartition {
    private Long id;
    private String libelle;
    private String description;
    private Long idModule;
    private String module;
    private String cours;
    private int coefficient;
    private int nbreHeure;
    private Long idClasse;
    private String classe;
    private Long idGroupe;
    private String groupe;
    private String filiere;
    private String semestre;

}
