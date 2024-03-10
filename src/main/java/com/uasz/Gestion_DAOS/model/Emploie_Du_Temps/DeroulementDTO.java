package com.uasz.Gestion_DAOS.model.Emploie_Du_Temps;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DeroulementDTO {
    private Long id;

    private String objectifs;
    // private Date date;

    private String description;

    public DeroulementDTO(Deroulement d) {
        this.id = d.getId();
        this.objectifs = d.getObjectifs();
        this.description = d.getDescription();

    }
}
