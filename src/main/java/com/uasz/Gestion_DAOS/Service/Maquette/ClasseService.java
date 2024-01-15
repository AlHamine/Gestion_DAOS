package com.uasz.Gestion_DAOS.Service.Maquette;

import com.uasz.Gestion_DAOS.Repository.Maquette.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;

    public Classe ajouterClasse(Classe classe) {
        classeRepository.save(classe);
        return classe;

    }

    public List<Classe> afficherToutClasse() {
        return classeRepository.findAll();
    }

    public Classe rechercherClasse(Long id) {
        return classeRepository.findById(id).get();
    }

    public Classe modifierClasse(Classe classe) {
        Classe classeModifier = rechercherClasse(classe.getId());
        if (classeModifier != null) {
            classeModifier.setNom(classe.getNom());
            classeModifier.setEnseignement(classe.getEnseignement());
            classeModifier.setFormation(classe.getFormation());
            classeModifier.setGroupes(classe.getGroupes());
            classeModifier.setSemestre(classe.getSemestre());
            return classeRepository.save(classeModifier);
        } else
            return null;
    }

    public Boolean suprimerClasse(Classe classe) {
        Classe classeModifier = rechercherClasse(classe.getId());
        if (classeModifier != null) {
            classeRepository.delete(classe);
            return true;
        } else
            return false;
    }

    public List<Enseignement> enseignements_classe(Long id) {
        return classeRepository.findById(id).get().getEnseignement();

    }

}
