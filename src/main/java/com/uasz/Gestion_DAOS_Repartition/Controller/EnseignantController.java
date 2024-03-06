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

import com.uasz.Gestion_DAOS_Repartition.Service.EnseignantService;
import com.uasz.Gestion_DAOS_Repartition.model.Enseignant;

@RestController
@RequestMapping("/repartition")
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    @GetMapping(path = "/enseignant")
    public List<Enseignant> listerEnseignant() {
        return enseignantService.afficherToutEnseignant();
    }

    @GetMapping(path = "/enseignant/{id}")
    public Enseignant recherchEnseignant(@PathVariable Long id) {
        return enseignantService.rechercherEnseignant(id);
    }

    @PostMapping(path = "/enseignant")
    public Enseignant ajouterEnseignant(@RequestBody Enseignant Enseignant) {
        return enseignantService.ajouterEnseignant(Enseignant);
    }

    @PutMapping(path = "/enseignant/{id}")
    public Enseignant modifierEnseignant(@RequestBody Enseignant Enseignant, @PathVariable Long id) {
        return enseignantService.modifierEnseignant(Enseignant);
    }

    @DeleteMapping(path = "/enseignant/{id}")
    public ResponseEntity<String> supprimerEnseignant(@PathVariable Long id) {
        enseignantService.suprimerEnseignant(id);
        return new ResponseEntity<>("Enseignant supprimée avec succès", HttpStatus.OK);
    }
}
