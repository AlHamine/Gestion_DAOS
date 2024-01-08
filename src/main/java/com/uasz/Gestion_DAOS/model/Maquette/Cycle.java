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
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom;

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "cycle")
    @OneToMany(mappedBy = "cycle")
    private List<Niveau> niveaux;
}

