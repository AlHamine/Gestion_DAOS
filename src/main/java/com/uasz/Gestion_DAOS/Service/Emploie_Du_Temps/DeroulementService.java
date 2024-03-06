package com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Repository.Emploie_Du_Temps.DeroulementRepository;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Deroulement;

import jakarta.transaction.Transactional;

/**
 * DeroulementService
 */
@Service
@Transactional

public class DeroulementService {
    @Autowired
    private DeroulementRepository deroulementRepository;

    public Deroulement ajouterDeroulement(Deroulement deroulement) {
        deroulementRepository.save(deroulement);
        return deroulement;

    }

    public List<Deroulement> afficherToutDeroulement() {
        return deroulementRepository.findAll();
    }

    public Deroulement rechercherDeroulement(Long id) {
        return deroulementRepository.findById(id).get();
    }

    public Deroulement modifierDeroulement(Deroulement deroulement) {
        Deroulement DeroulementModifier = rechercherDeroulement(deroulement.getId());
        if (DeroulementModifier != null) {
            // DeroulementModifier.setDate(deroulement.getDate());
            DeroulementModifier.setObjectifs(deroulement.getObjectifs());
            DeroulementModifier.setDescription(deroulement.getDescription());
            DeroulementModifier.setSeance(deroulement.getSeance());

            return deroulementRepository.save(DeroulementModifier);
        } else
            return null;
    }

    public Boolean suprimerDeroulement(Long deroulement) {
        Deroulement DeroulementModifier = rechercherDeroulement(deroulement);
        if (DeroulementModifier != null) {
            deroulementRepository.delete(DeroulementModifier);
            return true;
        } else
            return false;
    }

}