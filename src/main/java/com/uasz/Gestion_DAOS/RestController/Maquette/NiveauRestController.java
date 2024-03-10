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

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.NiveauService;
// import com.uasz.Gestion_DAOS.Service.Maquette.NiveauService;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;
import com.uasz.Gestion_DAOS.model.Maquette.Niveau;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/maquette")
public class NiveauRestController {

    private NiveauService niveauService;

    @GetMapping(path = "/niveau")
    public List<Niveau> listerNiveau() {
        return niveauService.afficherToutNiveau();
    }

    @GetMapping(path = "/niveau/{id}")
    public Niveau recherchNiveau(@PathVariable Long id) {
        return niveauService.rechercherNiveau(id);
    }

    @PostMapping(path = "/niveau")
    public Niveau ajouterNiveau(@RequestBody Niveau niveau) {
        return niveauService.ajouterNiveau(niveau);
    }

    @PutMapping(path = "/niveau/{id}")
    public Niveau modifierNiveau(@RequestBody Niveau niveau, @PathVariable Long id) {
        return niveauService.modifierNiveau(niveau);
    }

    @DeleteMapping(path = "/niveau/{id}")
    public ResponseEntity<String> supprimerNiveau(@PathVariable Long id) {
        niveauService.suprimerNiveau(id);
        return new ResponseEntity<>("Niveau supprimée avec succès", HttpStatus.OK);
    }

    @GetMapping(path = "/niveauDetailsFormation/{id}")
    public List<Formation> niveauDetailsFormation(@PathVariable Long id) {
        return niveauService.niveauDetailsFormation(id);
    }
}