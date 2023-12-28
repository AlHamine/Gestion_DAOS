package com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.uasz.Gestion_DAOS.Repository.Emploie_Du_Temps.SalleRepository;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Salle;
/**
 * SalleService
 */
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
            salleModifier.setCapacity(salle.getCapacity());
            salleModifier.setNumero(salle.getNumero());
            return salleRepository.save(salleModifier);
        } else
            return null;
    }

    public Boolean suprimerSalle(Salle batiment) {
        Salle salleModifier = rechercherSalle(batiment.getId());
        if (salleModifier != null) {
            salleRepository.delete(batiment);
            return true;
        } else
            return false;
    }

}