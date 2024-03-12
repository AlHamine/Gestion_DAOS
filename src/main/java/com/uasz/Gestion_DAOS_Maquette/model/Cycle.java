package com.uasz.Gestion_DAOS_Maquette.model;

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
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "cycle")
    @JsonIgnore
    @OneToMany(mappedBy = "cycle")
    private List<Niveau> niveaux;
    private Date createdAt = new Date();
}
