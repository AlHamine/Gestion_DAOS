package com.uasz.Gestion_DAOS.Service.Repartition.Maquette;

import com.uasz.Gestion_DAOS.Repository.Maquette.ClasseRepository;
import com.uasz.Gestion_DAOS.Repository.Maquette.GroupeRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Groupe;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        // Rechercher la classe dans la base de données par son ID
        Optional<Classe> classeOptional = classeRepository.findById(classe.getId());

        // Vérifier si la classe existe dans la base de données
        if (classeOptional.isPresent()) {
            // Obtenir la classe existante
            Classe classeExistante = classeOptional.get();
            // Copier les propriétés de la classe fournie vers la classe existante en
            // ignorant l'attribut 'id'
            BeanUtils.copyProperties(classe, classeExistante, "id");
            // Sauvegarder et retourner la classe modifiée
            return classeRepository.save(classeExistante);
        } else {
            // La classe n'existe pas dans la base de données, retourner null ou jeter une
            // exception selon le cas
            return null;
        }
    }

    public Boolean suprimerClasse(Long id) {
        Classe classeModifier = rechercherClasse(id);
        if (classeModifier != null) {
            classeRepository.delete(classeModifier);
            return true;
        } else
            return false;
    }

    // public List<Enseignement> enseignements_classe(Long id) {
    // return classeRepository.findById(id).get().getEnseignement();

    // }

    public List<Groupe> groupe_classe(Long id) {
        return classeRepository.findById(id).get().getGroupes();

    }

    public List<Groupe> classeDetailsGroupe(Long id) {
        return classeRepository.classeDetailsGroupe(id);
    }

    public List<Enseignement> classeDetailsEnseignement(Long id) {
        return classeRepository.classeDetailsEnseignement(id);
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
