package com.uasz.Gestion_DAOS_EmploiDuTemps.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_EmploiDuTemps.Repository.SeanceRepository;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Seance;

import jakarta.transaction.Transactional;


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
            seanceModifier.setDateDebut(seance.getDateDebut());
            seanceModifier.setDateFin(seance.getDateFin());
            seanceModifier.setDeroulement(seance.getDeroulement());
            seanceModifier.setEmploi(seance.getEmploi());
            seanceModifier.setRepartition(seance.getRepartition());
            seanceModifier.setTitre(seance.getTitre());
            return seanceRepository.save(seanceModifier);
        } else
            return null;
    }

    // public Boolean suprimerSeance(Seance batiment) {
    //     Seance seanceModifier = rechercherSeance(batiment.getId());
    //     if (seanceModifier != null) {
    //         seanceRepository.delete(batiment);
    //         return true;
    //     } else
    //         return false;
    // }

    public Boolean suprimerSeance(Long id) {
        Seance seanceModifier = rechercherSeance(id);
        if (seanceModifier != null) {
            seanceRepository.delete(seanceModifier);
            return true;
        } else
            return false;
    }

}