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
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nom;
    @ManyToOne
    private UE ue;
    @ManyToOne
    private EC ec;
    @ManyToOne
    private Semestre semestre;
    @ManyToMany (mappedBy = "module")
    private List<Enseignement>enseignements;
    @ManyToOne
    private Maquette maquette;

}
