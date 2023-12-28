package com.uasz.Gestion_DAOS.model.Emploie_Du_Temps;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.uasz.Gestion_DAOS.model.Repartition.Repartition;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    @ManyToOne
    private Emploi emploi;
    @OneToOne(mappedBy = "seance")
    private Deroulement deroulement ;
    @ManyToOne
    private Repartition repartition;
}
