package com.uasz.Gestion_DAOS_EmploiDuTemps.Controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.uasz.Gestion_DAOS_EmploiDuTemps.DTO.SeanceDTO;
import com.uasz.Gestion_DAOS_EmploiDuTemps.Service.SeanceService;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Seance;

@RestController
@RequestMapping("/emploi")
public class SeanceController {

    @Autowired
    private SeanceService seanceService;

    @GetMapping(path = "/seance")
    public List<Seance> listerSeance() {
        return seanceService.afficherToutSeance();
    }

    @GetMapping(path = "/seance/{id}")
    public Seance recherchSeance(@PathVariable Long id) {
        return seanceService.rechercherSeance(id);
    }

    @GetMapping(path = "/{id}/seance")
    public List<SeanceDTO> listerSeanceSelonEmploi(@PathVariable Long id) {
        return seanceService.afficherSeanceSelonEmploi(id).stream().map(s -> new SeanceDTO(s)).collect(Collectors.toList());
    }

    @PostMapping(path = "/seance")
    public Seance ajouterSeance(@RequestBody Seance Seance) {
        return seanceService.ajouterSeance(Seance);
    }

    @PutMapping(path = "/seance/{id}")
    public Seance modifierSeance(@RequestBody Seance Seance, @PathVariable Long id) {
        return seanceService.modifierSeance(Seance);
    }

    @DeleteMapping(path = "/seance/{id}")
    public ResponseEntity<String> supprimerSeance(@PathVariable Long id) {
        seanceService.suprimerSeance(id);
        return new ResponseEntity<>("Seance supprimée avec succès", HttpStatus.OK);
    }
}