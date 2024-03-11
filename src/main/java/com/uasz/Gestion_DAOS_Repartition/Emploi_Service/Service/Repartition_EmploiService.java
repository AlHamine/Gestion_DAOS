package com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Model.Repartition_Emploi;
import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Model.Enseignement;
import com.uasz.Gestion_DAOS_Repartition.Service.RepartitionService;
import com.uasz.Gestion_DAOS_Repartition.model.Repartition;

@Service
public class Repartition_EmploiService {
    @Autowired
    RepartitionService repartitionService;

    public List<Repartition_Emploi> lister_Repartition_Emplois() {
        List<Repartition> enseignements = repartitionService.afficherToutRepartition();

        List<Repartition_Emploi> enseignement_Repartitions = new ArrayList<>();

        for (Repartition enseignement : enseignements) {
            Repartition_Emploi repartition_Emploi = new Repartition_Emploi();
            repartition_Emploi.setId(enseignement.getId());
            if (enseignement.getEnseignement() != null) {
                repartition_Emploi.setClasse(enseignement.getEnseignement().getClasse());
                repartition_Emploi.setDescription(enseignement.getEnseignement().getDescription());
                repartition_Emploi.setIdModule(enseignement.getEnseignement().getIdModule());
                repartition_Emploi.setIdClasse(enseignement.getEnseignement().getIdClasse());
                repartition_Emploi.setNbreHeure(enseignement.getEnseignement().getNbreHeure());
                repartition_Emploi.setCoefficient(enseignement.getEnseignement().getCoefficient());
                repartition_Emploi.setLibelle(enseignement.getEnseignement().getLibelle());
                repartition_Emploi.setCours(enseignement.getEnseignement().getCours());
                if (enseignement.getEnseignement().getGroupe() != null) {
                    repartition_Emploi.setIdGroupe(enseignement.getEnseignement().getIdGroupe());
                    repartition_Emploi.setGroupe(enseignement.getEnseignement().getGroupe());

                }

                repartition_Emploi.setSemestre(enseignement.getEnseignement().getSemestre());
                enseignement_Repartitions.add(repartition_Emploi);
            }
            if (enseignement.getEnseignant() != null) {
                repartition_Emploi.setEnseignatId(enseignement.getEnseignant().getId());
                repartition_Emploi.setNom(enseignement.getEnseignant().getNom());
                repartition_Emploi.setPrenom(enseignement.getEnseignant().getPrenom());
                repartition_Emploi.setGrade(enseignement.getEnseignant().getGrade());
                // repartition_Emploi.setGrade(enseignement.getEnseignant().getGrade());

            }
            enseignement_Repartitions.add(repartition_Emploi);
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

    // public Repartition_Emploi rechercherEnseignement_Repartition(Long id) {
    // Enseignement enseignement = repartitionService.rechercherEnseignement(id);
    // Repartition_Emploi repartition_Emploi = new Repartition_Emploi();
    // repartition_Emploi.setClasse(enseignement.getClasse().getLibelle());
    // repartition_Emploi.setDescription(enseignement.getDescription());
    // repartition_Emploi.setId(enseignement.getId());
    // repartition_Emploi.setIdModule(enseignement.getModule().getId());
    // repartition_Emploi.setModule(enseignement.getModule().getNom());
    // repartition_Emploi.setIdClasse(enseignement.getClasse().getId());
    // repartition_Emploi.setNbreHeure(enseignement.getModule().getNbreHeure());
    // repartition_Emploi.setCoefficient(enseignement.getModule().getCoefficient());
    // repartition_Emploi.setLibelle(enseignement.getLibelle());
    // repartition_Emploi.setCours(enseignement.getModule().getCours());
    // if (enseignement.getGroupe() != null) {
    // repartition_Emploi.setIdGroupe(enseignement.getGroupe().getId());
    // repartition_Emploi.setGroupe(enseignement.getGroupe().getLibelle());

    // }

    // repartition_Emploi.setSemestre(enseignement.getClasse().getSemestre().getLibelle());

    // return repartition_Emploi;
    // }

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
