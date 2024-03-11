package com.uasz.Gestion_DAOS_EmploiDuTemps.Maquette_Service.Model;
import java.util.Collection;

import com.uasz.Gestion_DAOS_EmploiDuTemps.RepartitionService.model.Repartition;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String description;
    private Long idModule;
    private String cours;
    private int coefficient;
    private int nbreHeure;
    private Long idClasse;
    private String classe;
    private Long idGroupe;
    private String groupe;
    private String filiere;
    private String semestre;
    // @OneToMany(mappedBy = "enseignement", fetch = FetchType.LAZY)
    // private Repartition repartition;
    // private Collection<Repartition> repartition;

}
