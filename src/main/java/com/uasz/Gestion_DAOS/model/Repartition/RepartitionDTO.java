package com.uasz.Gestion_DAOS.model.Repartition;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

}