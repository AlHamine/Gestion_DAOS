package com.uasz.Gestion_DAOS.Service.Repartition;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Repository.Repartition.EnseignantRepository;
import com.uasz.Gestion_DAOS.model.Repartition.Enseignant;

import jakarta.transaction.Transactional;

/**
 * EnseignantService
 */
@Service
@Transactional
public class EnseignantService {

   
    @Autowired
    private EnseignantRepository enseignantRepository;

    public Enseignant ajouterEnseignant(Enseignant enseignant) {
        enseignantRepository.save(enseignant);
        return enseignant;

    }

    public List<Enseignant> afficherToutEnseignant() {
        return enseignantRepository.findAll();
    }

    public Enseignant rechercherEnseignant(Long id) {
        return enseignantRepository.findById(id).get();
    }

    public Enseignant modifierEnseignant(Enseignant enseignant) {
        Enseignant enseignantModifier = rechercherEnseignant(enseignant.getId());
        if (enseignantModifier != null) {
            enseignantModifier.setGrade(enseignant.getGrade());
            enseignantModifier.setNom(enseignant.getNom());
            enseignantModifier.setPrenom(enseignant.getPrenom());
            return enseignantRepository.save(enseignantModifier);
        } else
            return null;
    }

    public Boolean suprimerEnseignant(Enseignant enseignant) {
        Enseignant enseignantModifier = rechercherEnseignant(enseignant.getId());
        if (enseignantModifier != null) {
            enseignantRepository.delete(enseignant);
            return true;
        } else
            return false;
    }
 
}