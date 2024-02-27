package com.uasz.Gestion_DAOS_Repartition.MSMaquette.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UE {

    private Long id;
    private String libelle;
    private String Code;
    private String description;

    // private List<EC> ecs;

    // private List<Module> module;

    private Date createdAt;

    // private Utilisateur utilisateur;
    private int credit;
    private int coefficient;

}
