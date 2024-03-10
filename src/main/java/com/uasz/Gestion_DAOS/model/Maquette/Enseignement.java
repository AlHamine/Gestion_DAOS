package com.uasz.Gestion_DAOS.model.Maquette;

import java.util.Date;
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
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String libelle;
    @JsonIgnore
    private List<String> objectifs;
    private String description;
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private Groupe groupe;
    @ManyToOne
    private Module module;
    private Date createdAt = new Date();
}
