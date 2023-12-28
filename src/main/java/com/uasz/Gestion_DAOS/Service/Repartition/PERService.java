package com.uasz.Gestion_DAOS.Service.Repartition;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.Gestion_DAOS.Repository.Repartition.PERRepository;

import com.uasz.Gestion_DAOS.model.Repartition.PER;

/**
 * PERService
 */
public class PERService {

    
    @Autowired
    private PERRepository perRepository;

    public PER ajouterPER(PER per) {
        perRepository.save(per);
        return per;

    }

    public List<PER> afficherToutPER() {
        return perRepository.findAll();
    }

    public PER rechercherPER(Long id) {
        return perRepository.findById(id).get();
    }

    public PER modifierPER(PER per) {
        PER perModifier = rechercherPER(per.getId());
        if (perModifier != null) {
            perModifier.setGrade(per.getGrade());
            perModifier.setMatricule(per.getMatricule());
            perModifier.setNom(per.getNom());
            perModifier.setPrenom(per.getPrenom());
            perModifier.setSpecialite(per.getSpecialite());
            
            return perRepository.save(perModifier);
        } else
            return null;
    }

    public Boolean suprimerPER(PER per) {
        PER perModifier = rechercherPER(per.getId());
        if (perModifier != null) {
            perRepository.delete(per);
            return true;
        } else
            return false;
    }
 
}