package com.uasz.Gestion_DAOS.model.Repartition;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Seance;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;

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
    @ManyToOne
    private Enseignement enseignement;
    private int credit;
    private int dureeCours;
      @ManyToOne
    private Enseignant enseignant;
    private int cm;
    private String ResponsableTD;
    private String ResponsableTP;
    private int travauxDirige;
    private int travauxPratique;
    @OneToMany(mappedBy = "repartition")
    private List<Seance> seances;
}
