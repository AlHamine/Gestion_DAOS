package com.uasz.Gestion_DAOS_Maquette.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EnseignementDTO {
    private Long id;
    private String libelle;
    private String description;
    private String module;
    private String classe;
    private String semestre;
    private String groupe;
    // private Long repartitionId;
}
