package com.uasz.Gestion_DAOS.RestController.Maquette;

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

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.CycleService;
import com.uasz.Gestion_DAOS.model.Maquette.Cycle;


@RestController
@RequestMapping("/maquette")
public class CycleRestController {

    @Autowired
    private CycleService cycleService;

    @GetMapping(path = "/cycle")
    public List<Cycle> listerCycle() {
        return cycleService.afficherToutCycle();
    }

    @GetMapping(path = "/cycle/{id}")
    public Cycle recherchCycle(@PathVariable Long id) {
        return cycleService.rechercherCycle(id);
    }

    @PostMapping(path = "/cycle")
    public Cycle ajouterCycle(@RequestBody Cycle Cycle) {
        return cycleService.ajouterCycle(Cycle);
    }

    @PutMapping(path = "/cycle/{id}")
    public Cycle modifierCycle(@RequestBody Cycle Cycle, @PathVariable Long id) {
        return cycleService.modifierCycle(Cycle);
    }

    @DeleteMapping(path = "/cycle/{id}")
    public ResponseEntity<String> supprimerCycle(@PathVariable Long id) {
        cycleService.suprimerCycle(id);
        return new ResponseEntity<>("Cycle supprimée avec succès", HttpStatus.OK);
    }
}