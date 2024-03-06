package com.uasz.Gestion_DAOS.model.Maquette;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    @ManyToOne
    private Cycle cycle;
    @JsonIgnore
    @OneToMany(mappedBy = "niveau")
    private List<Formation> formations;
}
