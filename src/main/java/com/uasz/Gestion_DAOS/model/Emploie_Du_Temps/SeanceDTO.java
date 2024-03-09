package com.uasz.Gestion_DAOS.model.Emploie_Du_Temps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import com.uasz.Gestion_DAOS.Service.Mapper;
import com.uasz.Gestion_DAOS.model.Repartition.PER;
import com.uasz.Gestion_DAOS.model.Repartition.RepartitionDTO;
import com.uasz.Gestion_DAOS.model.Repartition.Vacataire;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeanceDTO {
    private Long id;
    private String heureDebut;
    private String dureee;
    private Long emploiId;
    private Long deroulementId;
    // private RepartitionDTO repartition;
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
        if (seance.getEmploi() != null) {
            this.emploiId = seance.getEmploi().getId();
        }
        if (seance.getDeroulement() != null) {
            this.deroulementId = seance.getDeroulement().getId();
        }
        if (seance.getRepartition() != null) {
            this.repartition = seance.getRepartition().getId().toString();

            // this.salleId = seance.getSalle().getId();
            if (seance.getRepartition().getEnseignement() != null) {
                this.libelle = seance.getRepartition().getEnseignement().getLibelle();
                this.semestre = seance.getRepartition().getEnseignement().getClasse().getSemestre().getLibelle();
                this.description = seance.getRepartition().getEnseignement().getDescription();
                this.module = seance.getRepartition().getEnseignement().getModule().getCours() + "-"
                        + seance.getRepartition().getEnseignement().getModule().getNom();
                this.classe = seance.getRepartition().getEnseignement().getClasse().getLibelle();

                if (seance.getRepartition().getEnseignement().getGroupe() != null)
                    this.groupe = seance.getRepartition().getEnseignement().getGroupe().getLibelle();
            }
            if (seance.getRepartition().getEnseignant() != null) {
                // Ensignant
                this.nom = seance.getRepartition().getEnseignant().getNom();
                this.prenom = seance.getRepartition().getEnseignant().getPrenom();
                this.grade = seance.getRepartition().getEnseignant().getGrade();
                if (seance.getRepartition().getEnseignant() instanceof Vacataire) {
                    Vacataire v = (Vacataire) seance.getRepartition().getEnseignant();
                    this.specialite = v.getSpecialite();
                } else {
                    PER p = (PER) seance.getRepartition().getEnseignant();
                    this.matricule = p.getMatricule();
                    this.specialite = p.getSpecialite();
                }
            }

        }
        if (seance.getSalle() != null)
            this.salle = Mapper.mapSalleToDTO(seance.getSalle());
    }
}
