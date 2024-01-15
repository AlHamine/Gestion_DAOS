package com.uasz.Gestion_DAOS.Service.Maquette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Repository.Maquette.CycleRepository;
import com.uasz.Gestion_DAOS.model.Maquette.Cycle;
import com.uasz.Gestion_DAOS.model.Maquette.Niveau;

import jakarta.transaction.Transactional;

// import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;
@Service
@Transactional

public class CycleService {
    @Autowired
    private CycleRepository cycleRepository;

    // @Autowired
    // private NiveauService niveauService;

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

    public List<Niveau> detailsNiveau(Long idCycle) {
    //     System.out.println("++++++++++" + cycleRepository.findById(idCycle).get().getNiveaux().toString());
    //     return cycleRepository.findById(idCycle).get().getNiveaux();
    //     // List<Long> listIDNiveaux = cycleRepository.findByCycle(idCycle);
    //     // return niveauService.rechercherNiveau(listIDNiveaux.get(0));
    //     // System.out.println("++++++++++++++" + cycleRepository.findByCycle(cycleRepository.findById(idCycle).get()).toString());
    //     // return cycleRepository.findByCycle(cycleRepository.findById(idCycle).get());

        return cycleRepository.findByCycle(cycleRepository.findById(idCycle).get());
    }

    // public List<Niveau> detailsNiveau(Long idCycle) {
    //     List<Long> listIDNiveaux = cycleRepository.findByCycle(idCycle);

    //     List<Niveau> niveaux = new ArrayList<>();
    //     for (Long idNiveau : listIDNiveaux) {
    //         Niveau niveau = niveauService.rechercherNiveau(idNiveau);
    //         // System.out.println(niveau.getNom());
    //         niveaux.add(niveau);
    //     }
        
    //     return niveaux;
    // }

    // public Niveau detailsNiveau(Long id) {
    //     List<Long> listID = cycleRepository.findByCycle(id);
    //     return niveauService.rechercherNiveau(listID.get(0));
    // }

    // public List<Niveau> detailsNiveau(Long idCycle) {
    //     List<Long> listIDNiveaux = cycleRepository.findByCycle(idCycle);

    //     return listIDNiveaux.stream()
    //             .map(niveauService::rechercherNiveau)
    //             .collect(Collectors.toList());
    // }

}
