package com.uasz.Gestion_DAOS.Service.Maquette;

import com.uasz.Gestion_DAOS.Repository.Maquette.ClasseRepository;
import com.uasz.Gestion_DAOS.Repository.Maquette.GroupeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.Groupe;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;
    @Autowired
    private GroupeRepository gRepository;

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
            classeModifier.setLibelle(classe.getLibelle());
            ;
            classeModifier.setEnseignement(classe.getEnseignement());
            classeModifier.setFormation(classe.getFormation());
            classeModifier.setGroupes(classe.getGroupes());
            classeModifier.setSemestre(classe.getSemestre());
            classeModifier.setDescription(classe.getDescription());
            classeModifier.setEffectif(classe.getEffectif());
            classeModifier.setNbreGroupe(classe.getNbreGroupe());
            return classeRepository.save(classeModifier);
        } else
            return null;
    }

    public Boolean suprimerClasse(Long id) {
        Classe classeModifier = rechercherClasse(id);
        if (classeModifier != null) {
            classeRepository.delete(classeModifier);
            return true;
        } else
            return false;
    }

    public List<Enseignement> enseignements_classe(Long id) {
        return classeRepository.findById(id).get().getEnseignement();

    }

    public List<Groupe> groupe_classe(Long id) {
        return classeRepository.findById(id).get().getGroupes();

    }

    // public List<Groupe> groupe_classe(Long id) {
    // return classeRepository.findByClasse(id);

    // }

    // public List<Groupe> groupe_classe(Long idc) {
    // List<Object[]> results = classeRepository.findByClasse(idc);

    // // Process the result and convert it into a List<Groupe>
    // List<Groupe> groupes = results.stream()
    // .map(result -> new Groupe((Long) result[0], (String) result[1], (Integer)
    // result[2], (String) result[3],
    // null, classeRepository.getById(idc)))
    // .collect(Collectors.toList());

    // groupes.stream().forEach(e -> System.out.println("+++++++++++++++++++++++" +
    // e));

    // return groupes;
    // }
}
