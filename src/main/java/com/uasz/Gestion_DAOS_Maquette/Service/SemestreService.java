package com.uasz.Gestion_DAOS_Maquette.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_Maquette.Repository.SemestreRepository;
import com.uasz.Gestion_DAOS_Maquette.model.Semestre;

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

}
