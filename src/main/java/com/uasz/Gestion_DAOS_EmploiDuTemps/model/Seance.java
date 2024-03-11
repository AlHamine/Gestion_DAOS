package com.uasz.Gestion_DAOS_EmploiDuTemps.model;

import com.uasz.Gestion_DAOS_EmploiDuTemps.RepartitionService.model.Repartition;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// import java.time.LocalDateTime;



// import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jour;
    private String heureDebut;
    private String dureee;

    @ManyToOne
    private Emploi emploi;
    @OneToOne(mappedBy = "seance")
    private Deroulement deroulement;
    @ManyToOne
    private Repartition repartition;
    @ManyToOne
    private Salle salle;
}
