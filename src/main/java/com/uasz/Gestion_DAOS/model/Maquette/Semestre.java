package com.uasz.Gestion_DAOS.model.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "semestre")
    private List<Classe> classes;
    @JsonIgnore
    @OneToMany(mappedBy = "semestre")
    private List<Module> modules;
}
