package com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Repository.Emploie_Du_Temps.SeanceRepository;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Seance;

import jakarta.transaction.Transactional;

/**
 * SeanceService
 */
@Service
@Transactional

public class SeanceService {

    @Autowired
    private SeanceRepository seanceRepository;

    public Seance ajouterSeance(Seance seance) {
        seanceRepository.save(seance);
        return seance;

    }

    public List<Seance> afficherToutSeance() {
        return seanceRepository.findAll();
    }

    public Seance rechercherSeance(Long id) {
        return seanceRepository.findById(id).get();
    }

    public Seance modifierSeance(Seance seance) {
        Seance seanceModifier = rechercherSeance(seance.getId());
        if (seanceModifier != null) {
            seanceModifier.setDureee(seance.getDureee());
            seanceModifier.setHeureDebut(seance.getHeureDebut());
            seanceModifier.setDeroulement(seance.getDeroulement());
            seanceModifier.setEmploi(seance.getEmploi());
            // seanceModifier.setRepartition(seance.getRepartition());
            // seanceModifier.setTitre(seance.getTitre());
            return seanceRepository.save(seanceModifier);
        } else
            return null;
    }

    public Boolean suprimerSeance(Long batiment) {
        Seance seanceModifier = rechercherSeance(batiment);
        if (seanceModifier != null) {
            seanceRepository.delete(seanceModifier);
            return true;
        } else
            return false;
    }

}