package com.uasz.Gestion_DAOS.model.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom;
    @OneToMany(mappedBy = "classe")
    private  List<Enseignement> enseignement;
    @ManyToOne
    private Semestre semestre;
    @ManyToMany (mappedBy = "classe")
    private List<Groupe> groupes;
    @ManyToOne
    private Formation formation;


}
