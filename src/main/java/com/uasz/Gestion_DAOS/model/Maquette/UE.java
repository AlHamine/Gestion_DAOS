package com.uasz.Gestion_DAOS.model.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import com.uasz.Gestion_DAOS.model.Utilisateur.Utilisateur;

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
    private String description;
    @OneToMany(mappedBy = "ue")
    private List<EC> ecs;
    
    @OneToMany(mappedBy = "ue")
    private List<Module> module;

    private Date createdAt = new Date();
    @ManyToOne
    private Utilisateur utilisateur;
    private int credit;
    private int coefficient;


}

