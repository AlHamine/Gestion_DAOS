package com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Repository.Emploie_Du_Temps.EmploiRepository;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Emploi;

import jakarta.transaction.Transactional;

/**
 * EmploiService
 */
@Service
@Transactional

public class EmploiService {

    
    @Autowired
    private EmploiRepository emploiRepository;

    public Emploi ajouterEmploi(Emploi emploi) {
        emploiRepository.save(emploi);
        return emploi;

    }

    public List<Emploi> afficherToutEmploi() {
        return emploiRepository.findAll();
    }

    public Emploi rechercherEmploi(Long id) {
        return emploiRepository.findById(id).get();
    }

    public Emploi modifierEmploi(Emploi emploi) {
        Emploi emploiModifier = rechercherEmploi(emploi.getId());
        if (emploiModifier != null) {
            emploiModifier.setSeances(emploi.getSeances());
            return emploiRepository.save(emploiModifier);
        } else
            return null;
    }

    public Boolean suprimerEmploi(Emploi batiment) {
        Emploi emploiModifier = rechercherEmploi(batiment.getId());
        if (emploiModifier != null) {
            emploiRepository.delete(batiment);
            return true;
        } else
            return false;
    }

}