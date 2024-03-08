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

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.MaquetteService;
import com.uasz.Gestion_DAOS.model.Maquette.Maquette;

@RestController
@RequestMapping("/maquette")
public class MaquetteRestController {

    @Autowired
    private MaquetteService maquetteService;

    @GetMapping(path = "/maquette")
    public List<Maquette> listerMaquette() {
        return maquetteService.afficherToutMaquette();
    }

    @GetMapping(path = "/maquette/{id}")
    public Maquette recherchMaquette(@PathVariable Long id) {
        return maquetteService.rechercherMaquette(id);
    }

    @PostMapping(path = "/maquette")
    public Maquette ajouterMaquette(@RequestBody Maquette Maquette) {
        return maquetteService.ajouterMaquette(Maquette);
    }

    @PutMapping(path = "/maquette/{id}")
    public Maquette modifierMaquette(@RequestBody Maquette Maquette, @PathVariable Long id) {
        return maquetteService.modifierMaquette(Maquette);
    }

    @DeleteMapping(path = "/maquette/{id}")
    public ResponseEntity<String> supprimerMaquette(@PathVariable Long id) {
        maquetteService.suprimerMaquette(id);
        return new ResponseEntity<>("Maquette supprimée avec succès", HttpStatus.OK);
    }
}