package com.uasz.Gestion_DAOS.Service.Maquette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uasz.Gestion_DAOS.Repository.Maquette.FormationRepository;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;
import com.uasz.Gestion_DAOS.model.Maquette.Niveau;

import jakarta.transaction.Transactional;
import java.util.List;
@Service
@Transactional

public class FormationService {
    @Autowired
    private FormationRepository formationRepository;

    public Formation ajouterFormation(Formation formation) {
        formationRepository.save(formation);
        return formation;

    }

    public List<Formation> afficherToutFormation() {
        return formationRepository.findAll();
    }

    public Formation rechercherFormation(Long id) {
        return formationRepository.findById(id).get();
    }

    public Formation modifierFormation(Formation formation) {
        Formation FormationModifier = rechercherFormation(formation.getId());
        if (FormationModifier != null) {
            FormationModifier.setClasses(formation.getClasses());
            FormationModifier.setFiliere(formation.getFiliere());
            FormationModifier.setMaquette(formation.getMaquette());
            FormationModifier.setNom(formation.getNom());

            return formationRepository.save(FormationModifier);
        } else
            return null;
    }

    public Boolean suprimerFormation(Formation formation) {
        Formation FormationModifier = rechercherFormation(formation.getId());
        if (FormationModifier != null) {
            formationRepository.delete(formation);
            return true;
        } else
            return false;
    }


    public Boolean suprimerFormation(Long formatonId) {
        Formation formationModifier = rechercherFormation(formatonId);
        if (formationModifier != null) {
            formationRepository.delete(formationModifier);
            return true;
        } else
            return false;
    }

    public Niveau detailsFormationNiveau(Long formationId) {
        // return formationRepository.findByNiveau(formationRepository.findById((formationId)).get());
        return formationRepository.findById((formationId)).get().getNiveau();
    }

}
