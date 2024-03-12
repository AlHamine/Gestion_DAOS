package com.uasz.Gestion_DAOS_Maquette.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS_Maquette.Service.ClasseService;
import com.uasz.Gestion_DAOS_Maquette.Service.EnseignementService;
import com.uasz.Gestion_DAOS_Maquette.Service.FiliereService;
import com.uasz.Gestion_DAOS_Maquette.Service.FormationService;

@RestController
@RequestMapping("/rapport")
public class RapportRestController {

    @Autowired
    private EnseignementService enseignementService;
    @Autowired
    private FormationService formationService;
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private ClasseService classeService;

    @GetMapping(path = "/classe")
    public int nbClasse() {
        return classeService.afficherToutClasse().size();
    }

    @GetMapping(path = "/enseignement")
    public int nbEnseignemnt() {
        return enseignementService.afficherToutEnseignement().size();
    }

    @GetMapping(path = "/formation")
    public int nbFormation() {
        return formationService.afficherToutFormation().size();
    }

    @GetMapping(path = "/filiere")
    public int nbFiliere() {
        return filiereService.afficherToutFiliere().size();
    }

    @GetMapping("/maquette")
    public Rapport rapport() {
        return new Rapport(nbEnseignemnt(), nbFormation(), nbFiliere(), nbClasse());
    }

}
