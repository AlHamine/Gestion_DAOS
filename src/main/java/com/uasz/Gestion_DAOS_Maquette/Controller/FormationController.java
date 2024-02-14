package com.uasz.Gestion_DAOS_Maquette.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS_Maquette.Service.FormationService;
import com.uasz.Gestion_DAOS_Maquette.model.Formation;

@RestController
@RequestMapping("/maquette")
public class FormationController {

    @Autowired
    private FormationService formationService;

    @GetMapping(path = "/formation")
    public List<Formation> listerFormation() {
        return formationService.afficherToutFormation();
    }

    @GetMapping(path = "/formation/{id}")
    public Formation recherchFormation(@PathVariable Long id) {
        return formationService.rechercherFormation(id);
    }

    @PostMapping(path = "/formation")
    public Formation ajouterFormation(@RequestBody Formation Formation) {
        return formationService.ajouterFormation(Formation);
    }

    @PutMapping(path = "/formation/{id}")
    public Formation modifierFormation(@RequestBody Formation Formation, @PathVariable Long id) {
        return formationService.modifierFormation(Formation);
    }

    @DeleteMapping(path = "/formation/{id}")
    public ResponseEntity<String> supprimerFormation(@PathVariable Long id) {
        formationService.suprimerFormation(id);
        return new ResponseEntity<>("Formation supprimée avec succès", HttpStatus.OK);
    }
}