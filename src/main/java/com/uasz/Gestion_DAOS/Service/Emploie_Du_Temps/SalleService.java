package com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Repository.Emploie_Du_Temps.SalleRepository;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Salle;

import jakarta.transaction.Transactional;

/**
 * SalleService
 */
@Service
@Transactional

public class SalleService {

    @Autowired
    private SalleRepository salleRepository;

    public Salle ajouterSalle(Salle salle) {
        salleRepository.save(salle);
        return salle;

    }

    public List<Salle> afficherToutSalle() {
        return salleRepository.findAll();
    }

    public Salle rechercherSalle(Long id) {
        return salleRepository.findById(id).get();
    }

    public Salle modifierSalle(Salle salle) {
        Salle salleModifier = rechercherSalle(salle.getId());
        if (salleModifier != null) {
            salleModifier.setBatiment(salle.getBatiment());
            salleModifier.setCapacite(salle.getCapacite());
            salleModifier.setNumero(salle.getNumero());
            return salleRepository.save(salleModifier);
        } else
            return null;
    }

    public Boolean suprimerSalle(long id) {
        Salle salleModifier = rechercherSalle(id);
        if (salleModifier != null) {
            salleRepository.delete(salleModifier);
            return true;
        } else
            return false;
    }

    public List<Salle> afficherSalleSelonBatiment(Long id) {
        // System.out.println("ttttttttttttttttttttttttt" +
        // salleRepository.findByBatiment(id).toString());
        return salleRepository.findByBatiment(id);
    }

}