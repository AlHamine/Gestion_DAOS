package com.uasz.Gestion_DAOS_Repartition.Controller;

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

import com.uasz.Gestion_DAOS_Repartition.Service.RepartitionService;
import com.uasz.Gestion_DAOS_Repartition.model.Repartition;

@RestController
@RequestMapping("/repartition")
public class RepartitionController {

    @Autowired
    private RepartitionService repartitionService;

    @GetMapping(path = "/repartition")
    public List<Repartition> listerRepartition() {
        return repartitionService.afficherToutRepartition();
    }

    @GetMapping(path = "/repartition/{id}")
    public Repartition recherchRepartition(@PathVariable Long id) {
        return repartitionService.rechercherRepartition(id);
    }

    @PostMapping(path = "/repartition")
    public Repartition ajouterRepartition(@RequestBody Repartition Repartition) {
        return repartitionService.ajouterRepartition(Repartition);
    }

    @PutMapping(path = "/repartition/{id}")
    public Repartition modifierRepartition(@RequestBody Repartition Repartition, @PathVariable Long id) {
        return repartitionService.modifierRepartition(Repartition);
    }

    @DeleteMapping(path = "/repartition/{id}")
    public ResponseEntity<String> supprimerRepartition(@PathVariable Long id) {
        repartitionService.suprimerRepartition(id);
        return new ResponseEntity<>("Repartition supprimée avec succès", HttpStatus.OK);
    }
}