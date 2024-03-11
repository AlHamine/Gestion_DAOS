package com.uasz.Gestion_DAOS_EmploiDuTemps.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_EmploiDuTemps.DTO.SeanceDTO;
import com.uasz.Gestion_DAOS_EmploiDuTemps.Repository.SalleRepository;
import com.uasz.Gestion_DAOS_EmploiDuTemps.Repository.SeanceRepository;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Seance;

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

    public List<Seance> afficherSeanceSelonEmploi(Long id) {
        return seanceRepository.findByEmploi(id);
    }
    // public List<Seance> afficherSeanceSelonEmploi(Long id) {
    // return seanceRepository.findAll().stream().filter(m ->
    // {if(m.getEmploi()!=null) return m.getEmploi().getId()== id; else return
    // null})
    // .collect(Collectors.toList());
    // }

    public Seance rechercherSeance(Long id) {
        return seanceRepository.findById(id).get();
    }

    public Seance modifierSeance(Seance seance) {
        Seance seanceModifier = rechercherSeance(seance.getId());
        if (seanceModifier != null) {
            seanceModifier.setJour(seance.getJour());
            seanceModifier.setDureee(seance.getDureee());
            seanceModifier.setHeureDebut(seance.getHeureDebut());
            if (seance.getDeroulement() != null)
                seanceModifier.setDeroulement(seance.getDeroulement());
            seanceModifier.setEmploi(seance.getEmploi());
            if (seance.getRepartition() != null)
                seanceModifier.setRepartition(seance.getRepartition());
            if (seance.getSalle() != null)
                seanceModifier.setSalle(seance.getSalle());
            // seanceModifier.setTitre(seance.getTitre());
            Seance s = seanceRepository.save(seanceModifier);
            return s;
            // return new SeanceDTO(s);
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