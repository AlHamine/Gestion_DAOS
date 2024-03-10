package com.uasz.Gestion_DAOS.RestController.EmploiDuTemps;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.DeroulementService;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Deroulement;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.DeroulementDTO;

@RestController
@RequestMapping("/emploi")
public class DeroulementRestController {

    @Autowired
    private DeroulementService deroulementService;

    @GetMapping(path = "/deroulement")
    public List<DeroulementDTO> listerDeroulement() {
        return deroulementService.afficherToutDeroulement().stream().map(m -> new DeroulementDTO(m))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/deroulement/{id}")
    public DeroulementDTO recherchDeroulement(@PathVariable Long id) {
        return new DeroulementDTO(deroulementService.rechercherDeroulement(id));
    }

    @GetMapping(path = "/seance/{id}/deroulement")
    public DeroulementDTO recherchDeroulementSeance(@PathVariable Long id) {
        return new DeroulementDTO(deroulementService.rechercherDeroulementSeancee(id));
    }

    @PostMapping(path = "/deroulement")
    public Deroulement ajouterDeroulement(@RequestBody Deroulement Deroulement) {
        return deroulementService.ajouterDeroulement(Deroulement);
    }

    @PatchMapping(path = "/deroulement/{id}")
    public Deroulement modifierDeroulement(@RequestBody Deroulement Deroulement, @PathVariable Long id) {
        return deroulementService.modifierDeroulement(Deroulement);
    }

    @DeleteMapping(path = "/deroulement/{id}")
    public ResponseEntity<String> supprimerDeroulement(@PathVariable Long id) {
        deroulementService.suprimerDeroulement(id);
        return new ResponseEntity<>("Deroulement supprimée avec succès", HttpStatus.OK);
    }
}