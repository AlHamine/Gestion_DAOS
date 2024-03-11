package com.uasz.Gestion_DAOS_EmploiDuTemps.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SalleDTO {

    private Long id;
    private String numero;

    private int capacite;
    private Long batimentId;
    private String batimentNom;
}
