package com.uasz.Gestion_DAOS_Repartition.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String libelle;
    private List<String> objectifs;
    private String description;
    // @ManyToOne
    // private Classe classe;
    // @ManyToOne
    // private Groupe groupe;
    // @ManyToOne
    // private Module module;
}
