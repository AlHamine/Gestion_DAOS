package com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Model.Seance;
import com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Repository.SeanceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SeanceService {
    @Autowired
    private SeanceRepository seanceRepository;

    public List<Seance> lister_Seance() {
        return seanceRepository.findAll();
    }

    public Seance Rechercher(Long id) {
        return seanceRepository.findById(id).get();

    }

    public Seance ajouter_Seance(Seance e) {
        return seanceRepository.save(e);

    }

    public Seance modifier_Seance(Seance e, Long id) {
        e.setId(id);
        return seanceRepository.save(e);

    }

    public void supprimerSeance(Long id) {
        seanceRepository.deleteById(id);
    }

}
