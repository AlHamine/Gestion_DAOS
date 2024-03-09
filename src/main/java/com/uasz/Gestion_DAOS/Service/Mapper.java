package com.uasz.Gestion_DAOS.Service;

import java.util.stream.Collectors;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Batiment;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.BatimentDTO;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Salle;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.SalleDTO;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.SeanceDTO;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.EnseignementDTO;
import com.uasz.Gestion_DAOS.model.Repartition.Enseignant;
import com.uasz.Gestion_DAOS.model.Repartition.EnseignantDTO;
import com.uasz.Gestion_DAOS.model.Repartition.PER;
import com.uasz.Gestion_DAOS.model.Repartition.PERDTO;
import com.uasz.Gestion_DAOS.model.Repartition.Repartition;
import com.uasz.Gestion_DAOS.model.Repartition.RepartitionDTO;
import com.uasz.Gestion_DAOS.model.Repartition.Vacataire;
import com.uasz.Gestion_DAOS.model.Repartition.VacataireDTO;

public class Mapper {
    public static BatimentDTO mapBatimentToDTO(Batiment b) {
        BatimentDTO bDTO = new BatimentDTO();
        bDTO.setId(b.getId());
        bDTO.setNom(b.getNom());
        bDTO.setSalles(b.getSalles().stream()
                .map(salle -> mapSalleToDTO(salle))
                .collect(Collectors.toList()));
        return bDTO;
    }

    public static SalleDTO mapSalleToDTO(Salle salle) {
        SalleDTO salleDTO = new SalleDTO();
        salleDTO.setId(salle.getId());
        salleDTO.setNumero(salle.getNumero());
        salleDTO.setCapacite(salle.getCapacite());
        salleDTO.setBatimentId(salle.getBatiment().getId());
        salleDTO.setBatimentNom(salle.getBatiment().getNom());
        return salleDTO;
    }

    public static RepartitionDTO mRepartitionDTO(Repartition repartition) {
        RepartitionDTO rDTO = new RepartitionDTO();
        rDTO.setId(repartition.getId());
        rDTO.setEnseignement(mapEnseignementToDTO(repartition.getEnseignement()));
        if (repartition.getEnseignant() instanceof PER)
            rDTO.setEnseignant(mapPerdto(repartition.getEnseignant()));

        else
            rDTO.setEnseignant(mapVacataireDTO(repartition.getEnseignant()));

        rDTO.setSeances(repartition.getSeances().stream().map(s -> new SeanceDTO(s)).collect(Collectors.toList()));

        return rDTO;
    }

    // EnseignementDTO
    public static VacataireDTO mapVacataireDTO(Enseignant e) {
        Vacataire enseignant = (Vacataire) e;
        // if (enseignant instanceof Vacataire) {
        VacataireDTO edto = new VacataireDTO();

        edto.setGrade(enseignant.getGrade());
        edto.setId(enseignant.getId());
        edto.setNom(enseignant.getNom());
        edto.setPrenom(enseignant.getPrenom());
        edto.setSpecialite(enseignant.getSpecialite());
        if (enseignant.getRepartitions() != null)
            edto.setRepartitions(
                    enseignant.getRepartitions().stream().map(repartition -> {
                        RepartitionDTO rDTO = new RepartitionDTO();
                        rDTO.setEnseignement(mapEnseignementToDTO(repartition.getEnseignement()));
                        // rDTO.setEnseignant(new
                        // VacataireDTO(edto.getId(),edto.getNom(),edto.getPrenom(),edto.getGrade(),null,edto.getSpecialite()));
                        rDTO.setSeances(repartition.getSeances().stream().map(s -> new SeanceDTO(s))
                                .collect(Collectors.toList()));

                        return rDTO;

                    }).collect(Collectors.toList()));

        return edto;
    }

    public static PERDTO mapPerdto(Enseignant e) {
        PER enseignant = (PER) e;
        PERDTO edto = new PERDTO();
        edto.setId(enseignant.getId());
        edto.setGrade(enseignant.getGrade());
        edto.setNom(enseignant.getNom());
        edto.setPrenom(enseignant.getPrenom());
        edto.setSpecialite(enseignant.getSpecialite());
        if (enseignant.getRepartitions() != null)
            edto.setRepartitions(
                    enseignant.getRepartitions().stream().map(repartition -> {
                        RepartitionDTO rDTO = new RepartitionDTO();
                        rDTO.setEnseignement(mapEnseignementToDTO(repartition.getEnseignement()));
                        // rDTO.setEnseignant(new VacataireDTO(edto.getId(), edto.getNom(),
                        // edto.getPrenom(),
                        // edto.getGrade(), null, edto.getSpecialite()));
                        rDTO.setSeances(repartition.getSeances().stream().map(s -> new SeanceDTO(s))
                                .collect(Collectors.toList()));

                        return rDTO;

                    }).collect(Collectors.toList()));

        edto.setMatricule(enseignant.getMatricule());

        return edto;

    }

    // /////////////// /////////////// /////////////// /////////////
    // edto.setRepartitions(null);

    public static EnseignementDTO mapEnseignementToDTO(Enseignement enseignement) {
        EnseignementDTO eDTO = new EnseignementDTO();
        eDTO.setId(enseignement.getId());
        eDTO.setClasse(enseignement.getClasse().getLibelle());
        eDTO.setDescription(enseignement.getDescription());
        eDTO.setLibelle(enseignement.getLibelle());
        if (enseignement.getGroupe() != null)
            eDTO.setGroupe(enseignement.getGroupe().getLibelle());
        eDTO.setModule(enseignement.getModule().getCours() + " - " + enseignement.getModule().getNom());
        eDTO.setSemestre(enseignement.getClasse().getSemestre().getLibelle());

        return eDTO;
    }
}
