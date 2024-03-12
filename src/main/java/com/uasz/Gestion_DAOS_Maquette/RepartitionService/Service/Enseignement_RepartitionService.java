package com.uasz.Gestion_DAOS_Maquette.RepartitionService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_Maquette.RepartitionService.model.Enseignement_Repartition;
import com.uasz.Gestion_DAOS_Maquette.Service.EnseignementService;
import com.uasz.Gestion_DAOS_Maquette.model.Enseignement;

@Service
public class Enseignement_RepartitionService {
    @Autowired
    EnseignementService enseignementService;

    public List<Enseignement_Repartition> lister_Enseignement_Repartition() {
        List<Enseignement> enseignements = enseignementService.afficherToutEnseignement();

        List<Enseignement_Repartition> enseignement_Repartitions = new ArrayList<>();

        for (Enseignement enseignement : enseignements) {
            Enseignement_Repartition enseignement_Repartition = new Enseignement_Repartition();
            enseignement_Repartition.setClasse(enseignement.getClasse().getLibelle());
            enseignement_Repartition.setDescription(enseignement.getDescription());
            enseignement_Repartition.setId(enseignement.getId());
            enseignement_Repartition.setIdModule(enseignement.getModule().getId());
            enseignement_Repartition.setModule(enseignement.getModule().getNom());
            enseignement_Repartition.setIdClasse(enseignement.getClasse().getId());
            enseignement_Repartition.setNbreHeure(enseignement.getModule().getNbreHeure());
            enseignement_Repartition.setCoefficient(enseignement.getModule().getCoefficient());
            enseignement_Repartition.setLibelle(enseignement.getLibelle());
            if (enseignement.getClasse().getFormation() != null)
                enseignement_Repartition.setFiliere(enseignement.getClasse().getFormation().getFiliere().getNom());
            enseignement_Repartition.setCours(enseignement.getModule().getCours());
            if (enseignement.getGroupe() != null) {
                enseignement_Repartition.setIdGroupe(enseignement.getGroupe().getId());
                enseignement_Repartition.setGroupe(enseignement.getGroupe().getLibelle());

            }

            enseignement_Repartition.setSemestre(enseignement.getClasse().getSemestre().getLibelle());
            enseignement_Repartitions.add(enseignement_Repartition);
        }
        return enseignement_Repartitions;
    }

    // public Boolean suprimerEnseignement_Repartition(Long id) {
    // Enseignement enseignementModifier = rechercherEnseignement(id);
    // if (enseignementModifier != null) {
    // enseignementRepository.delete(enseignementModifier);
    // return true;
    // } else
    // return false;
    // }

    public Enseignement_Repartition rechercherEnseignement_Repartition(Long id) {
        Enseignement enseignement = enseignementService.rechercherEnseignement(id);
        Enseignement_Repartition enseignement_Repartition = new Enseignement_Repartition();
        enseignement_Repartition.setClasse(enseignement.getClasse().getLibelle());
        enseignement_Repartition.setDescription(enseignement.getDescription());
        enseignement_Repartition.setId(enseignement.getId());
        enseignement_Repartition.setIdModule(enseignement.getModule().getId());
        enseignement_Repartition.setModule(enseignement.getModule().getNom());
        enseignement_Repartition.setIdClasse(enseignement.getClasse().getId());
        enseignement_Repartition.setNbreHeure(enseignement.getModule().getNbreHeure());
        enseignement_Repartition.setCoefficient(enseignement.getModule().getCoefficient());
        enseignement_Repartition.setLibelle(enseignement.getLibelle());
        enseignement_Repartition.setCours(enseignement.getModule().getCours());
        if (enseignement.getGroupe() != null) {
            enseignement_Repartition.setIdGroupe(enseignement.getGroupe().getId());
            enseignement_Repartition.setGroupe(enseignement.getGroupe().getLibelle());

        }

        enseignement_Repartition.setSemestre(enseignement.getClasse().getSemestre().getLibelle());

        return enseignement_Repartition;
    }

    // public Enseignement modifierEnseignement_Repartition(Enseignement
    // enseignement) {
    // Enseignement enseignementModifier =
    // rechercherEnseignement(enseignement.getId());
    // if (enseignementModifier != null) {
    // enseignementModifier.setClasse(enseignement.getClasse());
    // enseignementModifier.setGroupe(enseignement.getGroupe());
    // enseignementModifier.setModule(enseignement.getModule());
    // enseignementModifier.setLibelle(enseignement.getLibelle());
    // return enseignementRepository.save(enseignementModifier);
    // } else
    // return null;
    // }
}
