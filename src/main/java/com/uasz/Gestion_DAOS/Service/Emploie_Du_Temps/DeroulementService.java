package com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.Gestion_DAOS.Repository.Emploie_Du_Temps.DeroulementRepository;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Deroulement;

/**
 * DeroulementService
 */
public class DeroulementService {

    @Autowired
    private DeroulementRepository batimentRepository;

    public Deroulement ajouterDeroulement(Deroulement deroulement) {
        batimentRepository.save(deroulement);
        return deroulement;

    }

    public List<Deroulement> afficherToutDeroulement() {
        return batimentRepository.findAll();
    }

    public Deroulement rechercherDeroulement(Long id) {
        return batimentRepository.findById(id).get();
    }

    public Deroulement modifierDeroulement(Deroulement deroulement) {
        Deroulement DeroulementModifier = rechercherDeroulement(deroulement.getId());
        if (DeroulementModifier != null) {
            DeroulementModifier.setDate(deroulement.getDate());
            DeroulementModifier.setMatiere(deroulement.getMatiere());
            DeroulementModifier.setProcessus(deroulement.getProcessus());
            DeroulementModifier.setSeance(deroulement.getSeance());

            return batimentRepository.save(DeroulementModifier);
        } else
            return null;
    }

    public Boolean suprimerDeroulement(Deroulement deroulement) {
        Deroulement DeroulementModifier = rechercherDeroulement(deroulement.getId());
        if (DeroulementModifier != null) {
            batimentRepository.delete(deroulement);
            return true;
        } else
            return false;
    }

}