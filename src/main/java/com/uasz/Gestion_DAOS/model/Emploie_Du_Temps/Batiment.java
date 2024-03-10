package com.uasz.Gestion_DAOS.model.Emploie_Du_Temps;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Batiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @JsonIgnore
    @OneToMany(mappedBy = "batiment")
    private List<Salle> salles;
    private Date createdAt = new Date();
 
}
