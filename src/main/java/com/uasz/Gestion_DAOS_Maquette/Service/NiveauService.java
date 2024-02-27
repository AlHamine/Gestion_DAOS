package com.uasz.Gestion_DAOS_Maquette.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_Maquette.Repository.NiveauRepository;
import com.uasz.Gestion_DAOS_Maquette.model.Formation;
import com.uasz.Gestion_DAOS_Maquette.model.Niveau;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NiveauService {
    @Autowired
    private NiveauRepository niveauRepository;

    public Niveau ajouterNiveau(Niveau niveau) {
        niveauRepository.save(niveau);
        return niveau;

    }

    public List<Niveau> afficherToutNiveau() {
        return niveauRepository.findAll();
    }

    public Niveau rechercherNiveau(Long id) {
        return niveauRepository.findById(id).get();
    }

    public Niveau modifierNiveau(Niveau niveau) {
        Niveau niveauModifier = rechercherNiveau(niveau.getId());
        if (niveauModifier != null) {
            niveauModifier.setCycle(niveau.getCycle());
            niveauModifier.setNom(niveau.getNom());
            return niveauRepository.save(niveauModifier);
        } else
            return null;
    }

    public Boolean suprimerNiveau(Long id) {
        Niveau niveauModifier = rechercherNiveau(id);
        if (niveauModifier != null) {
            niveauRepository.delete(niveauModifier);
            return true;
        } else
            return false;
    }

    // public List<Cycle> getNiveauByCycle(Long id) {
    //     return niveauRepository.findAllById(id);
    // }

    public List<Formation> detailsFormationsDuNiveaux(Long niveauId) {
        return niveauRepository.findByFormation(niveauRepository.findById(niveauId).get());
    }

}