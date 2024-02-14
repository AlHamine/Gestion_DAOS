package com.uasz.Gestion_DAOS_EmploiDuTemps.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_EmploiDuTemps.Repository.BatimentRepository;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Batiment;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class BatimentService {
    @Autowired
    private BatimentRepository batimentRepository;

    public Batiment ajouterBatiment(Batiment Batiment) {
        batimentRepository.save(Batiment);
        return Batiment;
    }

    public List<Batiment> afficherToutBatiment() {
        return batimentRepository.findAll();
    }

    public Batiment rechercherBatiment(Long id) {
        return batimentRepository.findById(id).get();
    }

    public Batiment modifierBatiment(Batiment batiment) {
        Batiment BatimentModifier = rechercherBatiment(batiment.getId());
        if (BatimentModifier != null) {
            BatimentModifier.setNom(batiment.getNom());
            BatimentModifier.setSalles(batiment.getSalles());

            return batimentRepository.save(BatimentModifier);
        } else
            return null;
    }

    // public Boolean suprimerBatiment(Batiment batiment) {
    //     Batiment BatimentModifier = rechercherBatiment(batiment.getId());
    //     if (BatimentModifier != null) {
    //         batimentRepository.delete(batiment);
    //         return true;
    //     } else
    //         return false;
    // }

    public Boolean suprimerBatiment(Long id) {
        Batiment BatimentModifier = rechercherBatiment(id);
        if (BatimentModifier != null) {
            batimentRepository.delete(BatimentModifier);
            return true;
        } else
            return false;
    }

}
