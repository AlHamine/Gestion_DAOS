package com.uasz.Gestion_DAOS.model.Maquette;

import java.util.List;

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
    private  Long id;
    private  String name;
    @OneToMany
    private List<Enseignement> enseignement;
    @ManyToOne
    private Classe classe;
}
