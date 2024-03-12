package com.uasz.Gestion_DAOS_Maquette.DTO;

import org.springframework.beans.factory.annotation.Autowired;


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
    
    private int nbFormation;
    private int nbFiliere;
    private int nbClasse;



}
