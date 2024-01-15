package com.uasz.Gestion_DAOS.Service.Maquette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Repository.Maquette.GroupeRepository;
import com.uasz.Gestion_DAOS.model.Maquette.Groupe;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class GroupeService {
    @Autowired
    private GroupeRepository groupeRepository;

    public Groupe ajouterGroupe(Groupe groupe) {
        groupeRepository.save(groupe);
        return groupe;

    }

    public List<Groupe> afficherToutGroupe() {
        return groupeRepository.findAll();
    }

    public Groupe rechercherGroupe(Long id) {
        return groupeRepository.findById(id).get();
    }

    public Groupe modifierGroupe(Groupe groupe) {
        Groupe groupeModifier = rechercherGroupe(groupe.getId());
        if (groupeModifier != null) {
            groupeModifier.setClasse(groupe.getClasse());
            groupeModifier.setEnseignement(groupe.getEnseignement());
            groupeModifier.setLibelle(groupe.getLibelle());

            return groupeRepository.save(groupeModifier);
        } else
            return null;
    }

    public Boolean suprimerGroupe(Groupe groupe) {
        Groupe groupeModifier = rechercherGroupe(groupe.getId());
        if (groupeModifier != null) {
            groupeRepository.delete(groupe);
            return true;
        } else
            return false;
    }

}
