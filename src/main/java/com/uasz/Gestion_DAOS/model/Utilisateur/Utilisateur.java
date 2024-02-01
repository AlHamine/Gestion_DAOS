package com.uasz.Gestion_DAOS.model.Utilisateur;

import java.util.List;

import com.uasz.Gestion_DAOS.model.Maquette.UE;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String role;

    @OneToMany(mappedBy = "utilisateur")
    private List<UE> ues;
     
}
