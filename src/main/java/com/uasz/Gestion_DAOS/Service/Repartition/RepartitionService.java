package com.uasz.Gestion_DAOS.Service.Repartition;

import java.util.List;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Repository.Maquette.EnseignementRepository;
import com.uasz.Gestion_DAOS.Repository.Repartition.EnseignantRepository;
import com.uasz.Gestion_DAOS.Repository.Repartition.RepartitionRepository;
import com.uasz.Gestion_DAOS.Service.AllService;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Repartition.Enseignant;
import com.uasz.Gestion_DAOS.model.Repartition.Repartition;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

/**
 * RepartitionService
 */
@Service
@AllArgsConstructor
@Transactional
public class RepartitionService {

    private EnseignementRepository enseignementRepository;
    private EnseignantRepository enseignantRepository;
    private RepartitionRepository repartitionRepository;

    @SuppressWarnings("null")
    public Repartition ajouterRepartition(Repartition repartition) {
        repartitionRepository.save(repartition);
        return repartition;

    }

    public List<Repartition> afficherToutRepartition() {
        return repartitionRepository.findAll();
    }

    @SuppressWarnings("null")
    public Repartition rechercherRepartition(Long id) {
        return repartitionRepository.findById(id).get();
    }

    public Repartition modifierRepartition(Repartition repartition) {
        Repartition repartitionModifier = rechercherRepartition(repartition.getId());
        if (repartitionModifier != null) {
            repartitionModifier.setEnseignant(repartition.getEnseignant());
            repartitionModifier.setEnseignement(repartition.getEnseignement());
            if (repartition.getSeances() != null)
                repartitionModifier.setSeances(repartition.getSeances());

            return repartitionRepository.save(repartitionModifier);
        } else
            return null;
    }

    public Boolean suprimerRepartition(Long id) {
        Repartition repartitionModifier = rechercherRepartition(id);
        if (repartitionModifier != null) {
            repartitionRepository.delete(repartitionModifier);
            return true;
        } else
            return false;
    }

}