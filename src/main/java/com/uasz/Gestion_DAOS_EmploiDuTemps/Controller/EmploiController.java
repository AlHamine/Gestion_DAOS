package com.uasz.Gestion_DAOS_EmploiDuTemps.Controller;

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

import com.uasz.Gestion_DAOS_EmploiDuTemps.Service.EmploiService;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Emploi;

@RestController
@RequestMapping("/emploi")
public class EmploiController {

    @Autowired
    private EmploiService emploiService;

    @GetMapping(path = "/emploi")
    public List<Emploi> listerEmploi() {
        return emploiService.afficherToutEmploi();
    }

    @GetMapping(path = "/emploi/{id}")
    public Emploi recherchEmploi(@PathVariable Long id) {
        return emploiService.rechercherEmploi(id);
    }

    @PostMapping(path = "/emploi")
    public Emploi ajouterEmploi(@RequestBody Emploi Emploi) {
        return emploiService.ajouterEmploi(Emploi);
    }

    @PutMapping(path = "/emploi/{id}")
    public Emploi modifierEmploi(@RequestBody Emploi Emploi, @PathVariable Long id) {
        return emploiService.modifierEmploi(Emploi);
    }

    @DeleteMapping(path = "/emploi/{id}")
    public ResponseEntity<String> supprimerEmploi(@PathVariable Long id) {
        emploiService.suprimerEmploi(id);
        return new ResponseEntity<>("Emploi supprimée avec succès", HttpStatus.OK);
    }
}