package com.uasz.Gestion_DAOS.model.Emploie_Du_Temps;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.uasz.Gestion_DAOS.Service.Mapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmploiDTO {
    private Long id;
    private String filiere;
    private String classe;
    private List<SeanceDTO> seances;
    // Date Debut Date fin
    private Date dateDebut;
    private Date dateFin;

    public EmploiDTO(Emploi e) {
        this.id = e.getId();
        this.dateDebut = e.getDateDebut();
        this.dateFin = e.getDateFin();
        if (e.getSeances() != null && e.getSeances().size() != 0) {
            this.filiere = e.getSeances().get(0).getRepartition().getEnseignement().getClasse().getFormation()
                    .getFiliere().getNom();
            this.classe = e.getSeances().get(0).getRepartition().getEnseignement().getClasse().getLibelle() + "-"
                    + e.getSeances().get(0).getRepartition().getEnseignement().getClasse().getLibelle();
            setSeances(e.getSeances().stream().map(m -> new SeanceDTO(m)).collect(Collectors.toList()));

        }
    }
}
