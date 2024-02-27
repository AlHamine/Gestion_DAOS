package com.uasz.Gestion_DAOS_Maquette.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_Maquette.Repository.GroupeRepository;
import com.uasz.Gestion_DAOS_Maquette.model.Groupe;

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

    public Boolean suprimerGroupe(Long id) {
        Groupe groupeModifier = rechercherGroupe(id);
        if (groupeModifier != null) {
            groupeRepository.delete(groupeModifier);
            return true;
        } else
            return false;
    }

}