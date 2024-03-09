package com.uasz.Gestion_DAOS.model.Emploie_Du_Temps;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;

    private int capacite;

    @ManyToOne
    private Batiment batiment;
    @OneToMany(mappedBy = "salle")
    private List<Seance> seances;
}
