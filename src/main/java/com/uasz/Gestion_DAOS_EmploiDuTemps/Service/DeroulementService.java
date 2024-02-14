package com.uasz.Gestion_DAOS_EmploiDuTemps.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_EmploiDuTemps.Repository.DeroulementRepository;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Deroulement;

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
            DeroulementModifier.setDate(deroulement.getDate());
            DeroulementModifier.setMatiere(deroulement.getMatiere());
            DeroulementModifier.setProcessus(deroulement.getProcessus());
            DeroulementModifier.setSeance(deroulement.getSeance());

            return deroulementRepository.save(DeroulementModifier);
        } else
            return null;
    }

    // public Boolean suprimerDeroulement(Deroulement deroulement) {
    //     Deroulement DeroulementModifier = rechercherDeroulement(deroulement.getId());
    //     if (DeroulementModifier != null) {
    //         deroulementRepository.delete(deroulement);
    //         return true;
    //     } else
    //         return false;
    // }

    public Boolean suprimerDeroulement(Long id) {
        Deroulement deroulementModifier = rechercherDeroulement(id);
        if (deroulementModifier != null) {
            deroulementRepository.delete(deroulementModifier);
            return true;
        } else
            return false;
    }

}