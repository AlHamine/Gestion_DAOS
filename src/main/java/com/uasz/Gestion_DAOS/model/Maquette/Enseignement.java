package com.uasz.Gestion_DAOS.model.Maquette;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uasz.Gestion_DAOS.model.Repartition.Repartition;

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
    private Long id;
    private String libelle;
    @JsonIgnore
    private String objectifs;
    private String description;
    @ManyToOne
    private Module module;
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private Groupe groupe;
    private Date createdAt = new Date();
    @OneToOne
    private Repartition repartition;
}
