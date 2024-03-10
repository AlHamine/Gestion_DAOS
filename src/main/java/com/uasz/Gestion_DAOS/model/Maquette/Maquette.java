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
public class Maquette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    // private String ue;
    private int credit;
    private int coefUe;
    private String intitule;
    private int cm;
    private int td;
    private int tp;
    private int cumule;
    private int tpe;
    private int vh;
    private int coef;
    @OneToOne
    private Formation formation;
    @JsonIgnore
    @OneToMany(mappedBy = "maquette")
    private List<Module>modules;
    private Date createdAt = new Date();


}
