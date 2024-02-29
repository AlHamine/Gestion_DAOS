package com.uasz.Gestion_DAOS.model.Emploie_Du_Temps;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity

public class Batiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "batiment")
    private List<Salle> salles;

 
}
