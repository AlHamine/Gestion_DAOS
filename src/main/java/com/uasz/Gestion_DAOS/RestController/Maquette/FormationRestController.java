package com.uasz.Gestion_DAOS.RestController.Maquette;

import java.util.List;

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

import com.uasz.Gestion_DAOS.Service.Maquette.FormationService;
import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/maquette")
public class FormationRestController {

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

    @GetMapping(path = "/formationDetailsClasse/{id}")
    public List<Classe> formationDetailsClasse(@PathVariable Long id) {
        return formationService.formationDetailsClasse(id);
    }
}