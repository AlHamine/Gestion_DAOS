package com.uasz.Gestion_DAOS.model.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.uasz.Gestion_DAOS.model.Utilisateur.Utilisateur;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String Code;
    private int credit;
    private int coefficient;
    private String description;
    private Date createdAt = new Date();
    @JsonIgnore
    @OneToMany(mappedBy = "ue", cascade = CascadeType.ALL)
    private List<EC> ecs;
    @JsonIgnore
    @OneToMany(mappedBy = "ue")
    private List<Module> module;

    @Override
    public String toString() {
        return "UE{" + "id=" + id + ", libelle='" + libelle + '\'' + ", Code='" + Code + '\'' + // N'incluez pas 'module' ici pour éviter la récursion
                '}';
    }
}
