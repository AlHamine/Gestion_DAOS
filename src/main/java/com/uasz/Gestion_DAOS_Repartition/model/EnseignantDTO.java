package com.uasz.Gestion_DAOS_Repartition.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
// @JsonSubTypes({
//         @JsonSubTypes.Type(value = PERDTO.class, name = "PER"),
//         @JsonSubTypes.Type(value = VacataireDTO.class, name = "VAC")
// })
// // @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// // @DiscriminatorColumn(name = "type", length = 3)null
public class EnseignantDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String grade;

    // List<RepartitionDTO> repartitions;
//     public EnseignantDTO(Enseignant e) {
    
// }
}
