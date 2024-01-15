package com.uasz.Gestion_DAOS.Service.Maquette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uasz.Gestion_DAOS.Repository.Maquette.EnseignementRepository;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;

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

    public Boolean suprimerEnseignement(Enseignement enseignement) {
        Enseignement enseignementModifier = rechercherEnseignement(enseignement.getId());
        if (enseignementModifier != null) {
            enseignementRepository.delete(enseignement);
            return true;
        } else
            return false;
    }

 
}
