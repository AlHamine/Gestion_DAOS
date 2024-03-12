package com.uasz.Gestion_DAOS_Maquette.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private int effectif;
    private String description;
    @JsonIgnore
    @OneToMany
    private List<Enseignement> enseignement;
    @ManyToOne
    @JoinColumn(name = "classe")
    private Classe classe;

    @Override
    public String toString() {
        return this.getId() + " " + this.libelle + " " + this.effectif + " " + this.getDescription();
    }
    
}
