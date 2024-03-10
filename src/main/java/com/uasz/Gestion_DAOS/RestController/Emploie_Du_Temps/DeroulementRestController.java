package com.uasz.Gestion_DAOS.RestController.Emploie_Du_Temps;

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

import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.DeroulementService;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Deroulement;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/emploi")
public class DeroulementRestController {

    private DeroulementService deroulementService;

    @GetMapping(path = "/deroulement")
    public List<Deroulement> listerDeroulement() {
        return deroulementService.afficherToutDeroulement();
    }

    @GetMapping(path = "/deroulement/{id}")
    public Deroulement recherchDeroulement(@PathVariable Long id) {
        return deroulementService.rechercherDeroulement(id);
    }

    @PostMapping(path = "/deroulement")
    public Deroulement ajouterDeroulement(@RequestBody Deroulement Deroulement) {
        return deroulementService.ajouterDeroulement(Deroulement);
    }

    @PutMapping(path = "/deroulement/{id}")
    public Deroulement modifierDeroulement(@RequestBody Deroulement Deroulement, @PathVariable Long id) {
        return deroulementService.modifierDeroulement(Deroulement);
    }

    @DeleteMapping(path = "/deroulement/{id}")
    public ResponseEntity<String> supprimerDeroulement(@PathVariable Long id) {
        deroulementService.suprimerDeroulement(id);
        return new ResponseEntity<>("Deroulement supprimée avec succès", HttpStatus.OK);
    }
}