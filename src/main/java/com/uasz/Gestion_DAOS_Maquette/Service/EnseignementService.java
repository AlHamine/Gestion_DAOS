package com.uasz.Gestion_DAOS_Maquette.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_Maquette.Repository.EnseignementRepository;
import com.uasz.Gestion_DAOS_Maquette.model.Enseignement;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EnseignementService {
    @Autowired
    private EnseignementRepository enseignementRepository;

    public Enseignement ajouterEnseignement(Enseignement ue) {
        enseignementRepository.save(ue);
        return ue;
    }

    public List<Enseignement> afficherToutEnseignement() {
        return enseignementRepository.findAll();
    }

    public Enseignement rechercherEnseignement(Long id) {
        return enseignementRepository.findById(id).get();
    }

    public Enseignement modifierEnseignement(Enseignement enseignement) {
        Enseignement enseignementModifier = rechercherEnseignement(enseignement.getId());
        if (enseignementModifier != null) {
            enseignementModifier.setClasse(enseignement.getClasse());
            enseignementModifier.setGroupe(enseignement.getGroupe());
            enseignementModifier.setModule(enseignement.getModule());
            enseignementModifier.setLibelle(enseignement.getLibelle());
            return enseignementRepository.save(enseignementModifier);
        } else
            return null;
    }

    public Boolean suprimerEnseignement(Long id) {
        Enseignement enseignementModifier = rechercherEnseignement(id);
        if (enseignementModifier != null) {
            enseignementRepository.delete(enseignementModifier);
            return true;
        } else
            return false;
    }

}
