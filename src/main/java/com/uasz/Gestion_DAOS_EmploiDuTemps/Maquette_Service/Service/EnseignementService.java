package com.uasz.Gestion_DAOS_EmploiDuTemps.Maquette_Service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_EmploiDuTemps.Maquette_Service.Model.Enseignement;
import com.uasz.Gestion_DAOS_EmploiDuTemps.Maquette_Service.Repository.EnseignementRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EnseignementService {
    @Autowired
    private EnseignementRepository enseignementRepository;

    public List<Enseignement> lister_Enseignement() {
        return enseignementRepository.findAll();
    }

    public Enseignement Rechercher(Long id) {
        return enseignementRepository.findById(id).get();

    }

    public Enseignement ajouter_Enseignement(Enseignement e) {
        return enseignementRepository.save(e);

    }

    public Enseignement modifier_Enseignement(Enseignement e, Long id) {
        e.setId(id);
        return enseignementRepository.save(e);

    }

    public void supprimerEnseignement(Long id) {
        enseignementRepository.deleteById(id);
    }

}
