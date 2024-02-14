package com.uasz.Gestion_DAOS_EmploiDuTemps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String classe;
    private int effectif;
    private  int semestre;
    // @ManyToOne
    // private Enseignement enseignement;
    private int credit;
    private int dureeCours;
    // @ManyToOne
    // private Enseignant enseignant;
    private int cm;
    private String ResponsableTD;
    private String ResponsableTP;
    private int travauxDirige;
    private int travauxPratique;
    // @OneToMany(mappedBy = "repartition")
    // private List<Seance> seances;
}
