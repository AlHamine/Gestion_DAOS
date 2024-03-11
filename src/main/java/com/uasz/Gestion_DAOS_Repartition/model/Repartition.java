package com.uasz.Gestion_DAOS_Repartition.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Model.Seance;
import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Model.Enseignement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Enseignement enseignement;
  @ManyToOne
  private Enseignant enseignant;
  @JsonIgnore
  @OneToMany(mappedBy = "repartition")
  private List<Seance> seances;
}
