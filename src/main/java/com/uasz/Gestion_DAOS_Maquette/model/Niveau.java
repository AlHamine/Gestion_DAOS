package com.uasz.Gestion_DAOS_Maquette.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cycle")
    @ManyToOne
    private Cycle cycle;
    @OneToMany(mappedBy = "niveau")
    private List<Formation> formations;
}