package com.uasz.Gestion_DAOS.Service.Repartition;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.uasz.Gestion_DAOS.Repository.Repartition.VacataireRepository;
import com.uasz.Gestion_DAOS.model.Repartition.Vacataire;

/**
 * VacataireService
 */
public class VacataireService {

   
    @Autowired
    private VacataireRepository vacataireRepository;

    public Vacataire ajouterVacataire(Vacataire vacataire) {
        vacataireRepository.save(vacataire);
        return vacataire;

    }

    public List<Vacataire> afficherToutVacataire() {
        return vacataireRepository.findAll();
    }

    public Vacataire rechercherVacataire(Long id) {
        return vacataireRepository.findById(id).get();
    }

    public Vacataire modifierVacataire(Vacataire vacataire) {
        Vacataire vacataireModifier = rechercherVacataire(vacataire.getId());
        if (vacataireModifier != null) {
            vacataireModifier.setGrade(vacataire.getGrade());
            vacataireModifier.setNom(vacataire.getNom());
            vacataireModifier.setPrenom(vacataire.getPrenom());
            vacataireModifier.setSpecialite(vacataire.getSpecialite());
            return vacataireRepository.save(vacataireModifier);
        } else
            return null;
    }

    public Boolean suprimerVacataire(Vacataire vacataire) {
        Vacataire vacataireModifier = rechercherVacataire(vacataire.getId());
        if (vacataireModifier != null) {
            vacataireRepository.delete(vacataire);
            return true;
        } else
            return false;
    }
 
}