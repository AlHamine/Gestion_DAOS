// package com.uasz.Gestion_DAOS_Repartition.model;

// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// import java.util.List;
// import java.util.stream.Collectors;

// import com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Model.Seance;
// import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Model.Enseignement;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class RepartitionDTO {
//   private Long id;
//   private String libelle;
//   private String description;
//   private Long idModule;
//   private String cours;
//   private int coefficient;
//   private int nbreHeure;
//   private Long idClasse;
//   private String classe;
//   private Long idGroupe;
//   private String groupe;
//   private String semestre;
//   private Long enseignatEd;
//   private String nom;
//   private String prenom;
//   private String grade;

//   private List<Seance> seances;

//   // public RepartitionDTO(Repartition repartition) {
//   //   this.libelle = repartition.getEnseignement().getLibelle();
//   //   if (repartition.getEnseignement().getDescription() != null)
//   //     this.description = repartition.getEnseignement().getDescription();
//   //   this.idModule = repartition.getEnseignement().getIdModule();
//   //   this.idClasse = repartition.getEnseignement().getIdClasse();
//   //   if (repartition.getEnseignement().getIdGroupe() != null) {

//   //     this.idGroupe = repartition.getEnseignement().getIdGroupe();
//   //     this.groupe = repartition.getEnseignement().getGroupe();

//   //   }
    
//     // this.enseignement =
//     // Mapper.mapEnseignementToDTO(repartition.getEnseignement());
//     // if (repartition.getEnseignant() instanceof PER)
//     // this.setEnseignant(Mapper.mapPerdto(repartition.getEnseignant()));

//     // else
//     // this.setEnseignant(Mapper.mapVacataireDTO(repartition.getEnseignant()));

//     // // this.setSeances(repartition.getSeances().stream().map(s -> new
//     // // SeanceDTO(s)).collect(Collectors.toList()));

//   }
// }