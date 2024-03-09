package com.uasz.Gestion_DAOS.model.Repartition;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import com.uasz.Gestion_DAOS.Service.Mapper;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Seance;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.SeanceDTO;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.EnseignementDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepartitionDTO {
  private Long id;
  private EnseignementDTO enseignement;

  private EnseignantDTO enseignant;

  private List<SeanceDTO> seances;

  // public RepartitionDTO(Repartition repartition) {
  //   this.enseignement = Mapper.mapEnseignementToDTO(repartition.getEnseignement());
  //   if (repartition.getEnseignant() instanceof PER)
  //     this.setEnseignant(Mapper.mapPerdto(repartition.getEnseignant()));

  //   else
  //     this.setEnseignant(Mapper.mapVacataireDTO(repartition.getEnseignant()));

  //   // this.setSeances(repartition.getSeances().stream().map(s -> new
  //   // SeanceDTO(s)).collect(Collectors.toList()));

  // }
}