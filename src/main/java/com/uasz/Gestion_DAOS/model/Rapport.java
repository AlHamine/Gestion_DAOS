package com.uasz.Gestion_DAOS.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.Gestion_DAOS.Service.AllService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Rapport {
    private int nbEnseignemnt;
    private int nbEnseignant;
    private int nbVac;
    private int nbPER;
    private int nbFormation;
    private int nbFiliere;
    private int nbSalle;
    private int nbBatiment;
    private int nbClasse;
    private int nbSeance;
    private int nbRepartition;

}
