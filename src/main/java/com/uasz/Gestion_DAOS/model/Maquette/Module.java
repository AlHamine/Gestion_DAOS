package com.uasz.Gestion_DAOS.model.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String cours;
    private int coefficient;
    private int nbreHeure;
    private String description;
    private String objectifs;
    @ManyToOne
    private Maquette maquette;
    @ManyToOne
    private UE ue;
    @ManyToOne
    private EC ec;
    @ManyToOne
    private Semestre semestre;
    @JsonIgnore
    @ManyToMany (mappedBy = "module")
    private List<Enseignement>enseignements;
    private Date createdAt = new Date();

}
