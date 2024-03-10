package com.uasz.Gestion_DAOS.Service.Maquette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uasz.Gestion_DAOS.Repository.Maquette.SemestreRepository;
import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Semestre;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class SemestreService {
    @Autowired
    private SemestreRepository semestreRepository;

    public Semestre ajouterSemestre(Semestre semestre) {
        semestreRepository.save(semestre);
        return semestre;

    }

    public List<Semestre> afficherToutSemestre() {
        return semestreRepository.findAll();
    }

    public Semestre rechercherSemestre(Long id) {
        return semestreRepository.findById(id).get();
    }

    public Semestre modifierSemestre(Semestre semestre) {
        Semestre semestreModifier = rechercherSemestre(semestre.getId());
        if (semestreModifier != null) {
            semestreModifier.setClasses(semestre.getClasses());
            semestreModifier.setModules(semestre.getModules());
            semestreModifier.setLibelle(semestre.getLibelle());
            semestreModifier.setDescription(semestre.getDescription());
            return semestreRepository.save(semestreModifier);
        } else
            return null;
    }

    public Boolean suprimerSemestre(Long id) {
        Semestre semestreModifier = rechercherSemestre(id);
        if (semestreModifier != null) {
            semestreRepository.delete(semestreModifier);
            return true;
        } else
            return false;
    }

    public List<Classe> semestreDetailsClasse(Long id) {
        return semestreRepository.semestreDetailsClasse(id);
    }

    public List<com.uasz.Gestion_DAOS.model.Maquette.Module> semestreDetailsModule(Long id) {
        return semestreRepository.semestreDetailsModule(id);
    }

}
