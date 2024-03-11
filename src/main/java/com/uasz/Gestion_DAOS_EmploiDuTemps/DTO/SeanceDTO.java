package com.uasz.Gestion_DAOS_EmploiDuTemps.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Seance;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeanceDTO {
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
    private SalleDTO salle;
    private String specialite;
    private String matricule;

    // Constructeur à partir d'une Seance
    public SeanceDTO(Seance seance) {
        this.id = seance.getId();
        this.jour = seance.getJour();
        this.heureDebut = seance.getHeureDebut();
        this.dureee = seance.getDureee();
        if (seance.getDeroulement() != null) {
            this.deroulement_objectifs = seance.getDeroulement().getDescription();
            this.deroulement_desc = seance.getDeroulement().getDescription();
        }
        if (seance.getEmploi() != null) {
            this.emploiId = seance.getEmploi().getId();
        }
        if (seance.getDeroulement() != null) {
            this.deroulementId = seance.getDeroulement().getId();
        }
        if (seance.getRepartition() != null) {
            this.repartition = seance.getRepartition().getId().toString();

            // this.salleId = seance.getSalle().getId();
            // if (seance.getRepartition(). != null) {
                this.libelle = seance.getRepartition().getLibelle();
                // this.semestre = seance.getRepartition().gets
                this.description = seance.getRepartition().getDescription();
                this.module = seance.getRepartition().getCours() + "-"
                        + seance.getRepartition().getModule();
                this.classe = seance.getRepartition().getClasse();

                // if (seance.getRepartition().getGroupe() != null)
                this.groupe = seance.getRepartition().getGroupe();
            // }
            // if (seance.getRepartition().getEnseignant() != null) {
                // Ensignant
                this.nom = seance.getRepartition().getNom();
                this.prenom = seance.getRepartition().getPrenom();
                this.grade = seance.getRepartition().getGrade();
                if(seance.getRepartition().getMatricule()!=null)
                this.matricule=seance.getRepartition().getMatricule();
                this.specialite=seance.getRepartition().getSpecialite();
            // }

        }
        if (seance.getSalle() != null)
            this.salle = Mapper.mapSalleToDTO(seance.getSalle());
    }
}
