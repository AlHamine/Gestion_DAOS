package com.uasz.Gestion_DAOS.Service.Maquette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Repository.Maquette.CycleRepository;
import com.uasz.Gestion_DAOS.model.Maquette.Cycle;

import jakarta.transaction.Transactional;
import java.util.List;
@Service
@Transactional

public class CycleService {
    @Autowired
    private CycleRepository cycleRepository;

    public Cycle ajouterCycle(Cycle cycle) {
        cycleRepository.save(cycle);
        return cycle;

    }

    public List<Cycle> afficherToutCycle() {
        return cycleRepository.findAll();
    }

    public Cycle rechercherCycle(Long id) {
        return cycleRepository.findById(id).get();
    }

    public Cycle modifierCycle(Cycle cycle) {
        Cycle cycleModifier = rechercherCycle(cycle.getId());
        if (cycleModifier != null) {
            cycleModifier.setNiveaux(cycle.getNiveaux());
            cycleModifier.setNom(cycle.getNom());

            return cycleRepository.save(cycleModifier);
        } else
            return null;
    }

    public Boolean suprimerCycle(Cycle cycle) {
        Cycle cycleModifier = rechercherCycle(cycle.getId());
        if (cycleModifier != null) {
            cycleRepository.delete(cycle);
            return true;
        } else
            return false;
    }

    public Boolean suprimerCycle(Long id) {
        Cycle cycle = rechercherCycle(id);
        if (cycle!= null) {
            cycleRepository.delete(cycle);
            return true;
        }
        return false;
    }
}
