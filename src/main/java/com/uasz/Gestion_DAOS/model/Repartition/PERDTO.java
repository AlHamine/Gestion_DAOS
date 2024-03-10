package com.uasz.Gestion_DAOS.model.Repartition;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
// @DiscriminatorValue("PER")
public class PERDTO extends EnseignantDTO {
    private String matricule;
    private String specialite;

    public PERDTO(Long id, String nom, String prenom, String grade, List<RepartitionDTO> repartitions, String matricule,
            String specialite) {
        super(id, nom, prenom, grade, repartitions);
        this.matricule = matricule;
        this.specialite = specialite;
    }

}
