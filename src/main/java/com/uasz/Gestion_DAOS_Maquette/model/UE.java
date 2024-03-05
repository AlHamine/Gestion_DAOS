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
public class UE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String Code;
    private int credit;
    private int coefficient;
    private String description;
    private Date createdAt = new Date();
    @JsonIgnore
    @OneToMany(mappedBy = "ue", cascade = CascadeType.ALL)
    private List<EC> ecs;

    @OneToMany(mappedBy = "ue")
    private List<Module> module;

    // @ManyToOne
    // private Utilisateur utilisateur;

}
