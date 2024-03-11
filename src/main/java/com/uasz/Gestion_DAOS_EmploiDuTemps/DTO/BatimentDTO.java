package com.uasz.Gestion_DAOS_EmploiDuTemps.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatimentDTO {
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "batiment")
    @JsonIgnoreProperties("batiment")
    private List<SalleDTO> salles;
    // public void setSalles(List<SalleDTO> collect) {
    // this.salles
    // }

}
