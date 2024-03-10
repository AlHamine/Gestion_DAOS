package com.uasz.Gestion_DAOS.Service.Maquette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Repository.Maquette.FiliereRepository;
import com.uasz.Gestion_DAOS.model.Maquette.Cycle;
import com.uasz.Gestion_DAOS.model.Maquette.Filiere;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;

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

    public List<Formation> filiereDetailsFormation(Long id) {
        return filiereRepository.filiereDetailsFormation(id);
    }
}
