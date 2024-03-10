package com.uasz.Gestion_DAOS.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS.Service.AllService;
import com.uasz.Gestion_DAOS.model.Rapport;

@RestController
@RequestMapping("/rapport")
public class RapportRestController {

    @Autowired
    private AllService all;

    @GetMapping
    public Rapport rapport() {
        return all.getRapport();
    }

    @GetMapping(path = "/enseignement")
    public int nbEnseignemnt() {
        return all.enseignementService.afficherToutEnseignement().size();
    }

    @GetMapping(path = "/enseignant")
    public int nbEnseignant() {
        return all.enseignantService.afficherToutEnseignant().size();
    }

    @GetMapping(path = "/vac")
    public int nbVac() {
        return all.vacataireService.afficherToutVacataire().size();
    }

    @GetMapping(path = "/per")
    public int nbPER() {
        return all.perService.afficherToutPER().size();
    }

    @GetMapping(path = "/formation")
    public int nbFormation() {
        return all.formationService.afficherToutFormation().size();
    }

    @GetMapping(path = "/filiere")
    public int nbFiliere() {
        return all.filiereService.afficherToutFiliere().size();
    }

    @GetMapping(path = "/salle")
    public int nbSalle() {
        return all.salleService.afficherToutSalle().size();
    }

    @GetMapping(path = "/classe")
    public int nbClasse() {
        return all.classeService.afficherToutClasse().size();
    }

    @GetMapping(path = "/batiment")
    public int nbBatiment() {
        return all.batimentService.afficherToutBatiment().size();
    }

    @GetMapping(path = "/seance")
    public int nbSeance() {
        return all.seanceService.afficherToutSeance().size();
    }

    @GetMapping(path = "/repartition")
    public int nbRepartition() {
        return all.repartitionService.afficherToutRepartition().size();
    }

}