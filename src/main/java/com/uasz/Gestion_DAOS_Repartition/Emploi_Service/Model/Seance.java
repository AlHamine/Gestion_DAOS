package com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Model;

import java.util.Collection;
import com.uasz.Gestion_DAOS_Repartition.model.Repartition;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String heureDebut;
    private String dureee;
    private Long emploiId;
    private Long deroulementId;
    private String deroulement_objectifs;
    private String deroulement_desc;
    // Enseignements
    private String jour;
    private String repartition;
    private String libelle;
    private String description;
    private String module;
    private String classe;
    // private Long salleId;
    private String semestre;
    private String groupe;
    // Ensignant
    private String nom;
    private String prenom;
    private String grade;
    // private SalleDTO salle;
    private String specialite;
    private String matricule;
}
