package com.uasz.Gestion_DAOS.model.Emploie_Du_Temps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeanceDTO {
    private Long id;
    private LocalDateTime heureDebut;
    private String dureee;
    private Long emploiId;
    private Long deroulementId;
    private Long repartitionId;

    // Constructeur à partir d'une Seance
    public SeanceDTO(Seance seance) {
        this.id = seance.getId();
        this.heureDebut = seance.getHeureDebut();
        this.dureee = seance.getDureee();
        if (seance.getEmploi() != null) {
            this.emploiId = seance.getEmploi().getId();
        }
        if (seance.getDeroulement() != null) {
            this.deroulementId = seance.getDeroulement().getId();
        }
        if (seance.getRepartition() != null) {
            this.repartitionId = seance.getRepartition().getId();
        }
    }
}
