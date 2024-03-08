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

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ECService;
import com.uasz.Gestion_DAOS.model.Maquette.EC;


@RestController
@RequestMapping("/maquette")
public class ECRestController {

    @Autowired
    private ECService ecService;

    @GetMapping(path = "/ec")
    public List<EC> listerEC() {
        return ecService.afficherToutEC();
    }

    @GetMapping(path = "/ec/{id}")
    public EC recherchEC(@PathVariable Long id) {
        return ecService.rechercherEC(id);
    }

    @PostMapping(path = "/ec")
    public EC ajouterEC(@RequestBody EC EC) {
        return ecService.ajouterEC(EC);
    }

    @PutMapping(path = "/ec/{id}")
    public EC modifierEC(@RequestBody EC EC, @PathVariable Long id) {
        return ecService.modifierEC(EC);
    }

    @DeleteMapping(path = "/ec/{id}")
    public ResponseEntity<String> supprimerEC(@PathVariable Long id) {
        ecService.suprimerEC(id);
        return new ResponseEntity<>("EC supprimée avec succès", HttpStatus.OK);
    }
}