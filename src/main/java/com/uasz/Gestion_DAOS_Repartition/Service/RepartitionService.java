package com.uasz.Gestion_DAOS_Repartition.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_Repartition.Repository.RepartitionRepository;
import com.uasz.Gestion_DAOS_Repartition.model.Repartition;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RepartitionService {

    @Autowired
    private RepartitionRepository repartitionRepository;

    public Repartition ajouterRepartition(Repartition repartition) {
        repartitionRepository.save(repartition);
        return repartition;

    }

    public List<Repartition> afficherToutRepartition() {
        return repartitionRepository.findAll();
    }

    public Repartition rechercherRepartition(Long id) {
        return repartitionRepository.findById(id).get();
    }

    public Repartition modifierRepartition(Repartition repartition) {
        Repartition repartitionModifier = rechercherRepartition(repartition.getId());
        if (repartitionModifier != null) {
            repartitionModifier.setClasse(repartition.getClasse());
            repartitionModifier.setCm(repartition.getCm());
            repartitionModifier.setCredit(repartition.getCredit());
            repartitionModifier.setDureeCours(repartition.getDureeCours());
            repartitionModifier.setEffectif(repartition.getEffectif());
            repartitionModifier.setEnseignant(repartition.getEnseignant());
            repartitionModifier.setEnseignement(repartition.getEnseignement());
            repartitionModifier.setResponsableTD(repartition.getResponsableTD());
            // repartitionModifier.setSeances(repartition.getSeances());
            repartitionModifier.setSemestre(repartition.getSemestre());
            repartitionModifier.setTravauxDirige(repartition.getTravauxDirige());
            repartition.setTravauxPratique(repartition.getTravauxPratique());

            return repartitionRepository.save(repartitionModifier);
        } else
            return null;
    }

    // public Boolean suprimerRepartition(Repartition repartition) {
    // Repartition repartitionModifier = rechercherRepartition(repartition.getId());
    // if (repartitionModifier != null) {
    // repartitionRepository.delete(repartition);
    // return true;
    // } else
    // return false;
    // }

    public Boolean suprimerRepartition(Long id) {
        Repartition repartitionModifier = rechercherRepartition(id);
        if (repartitionModifier != null) {
            repartitionRepository.delete(repartitionModifier);
            return true;
        } else
            return false;
    }

}