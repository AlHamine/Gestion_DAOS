package com.uasz.Gestion_DAOS_Maquette.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_Maquette.Repository.FiliereRepository;
import com.uasz.Gestion_DAOS_Maquette.model.Filiere;
import com.uasz.Gestion_DAOS_Maquette.model.Formation;

import jakarta.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;

    public Filiere ajouterFiliere(Filiere filiere) {
        filiereRepository.save(filiere);
        return filiere;
    }

    public List<Filiere> afficherToutFiliere() {
        return filiereRepository.findAll();
    }

    public Filiere rechercherFiliere(Long id) {
        return filiereRepository.findById(id).get();
    }

    public Filiere modifierFiliere(Filiere filiere) {
        Filiere FiliereModifier = rechercherFiliere(filiere.getId());
        if (FiliereModifier != null) {
            FiliereModifier.setFormations(filiere.getFormations());
            FiliereModifier.setNom(filiere.getNom());
            return filiereRepository.save(FiliereModifier);
        } else
            return null;
    }

    public Boolean suprimerFiliere(Filiere filiere) {
        Filiere FiliereModifier = rechercherFiliere(filiere.getId());
        if (FiliereModifier != null) {
            filiereRepository.delete(filiere);
            return true;
        } else
            return false;
    }

    public Boolean suprimerFiliere(Long id) {
        Filiere filiere = rechercherFiliere(id);
        if (filiere!= null) {
            filiereRepository.delete(filiere);
            return true;
        }
        return false;
    }

    public List<Formation> detailsFormation(Long filiereId) {
        return filiereRepository.findByFormation(filiereRepository.findById(filiereId).get());
    }
}
