package com.uasz.Gestion_DAOS_Maquette.Controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
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

import com.uasz.Gestion_DAOS_Maquette.Mapper;
import com.uasz.Gestion_DAOS_Maquette.DTO.EnseignementDTO;
import com.uasz.Gestion_DAOS_Maquette.Service.EnseignementService;
import com.uasz.Gestion_DAOS_Maquette.model.Enseignement;


@RestController
@RequestMapping("/maquette")
public class EnseignementController {

    @Autowired
    private EnseignementService enseignementService;

    @GetMapping(path = "/enseignement")
    public List<EnseignementDTO> listerEnseignement() {
        return enseignementService.afficherToutEnseignement().stream().map(e -> Mapper.mapEnseignementToDTO(e))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/enseignement/{id}")
    public Enseignement recherchEnseignement(@PathVariable Long id) {
        return enseignementService.rechercherEnseignement(id);
    }

    @PostMapping(path = "/enseignement")
    public Enseignement ajouterEnseignement(@RequestBody Enseignement Enseignement) {
        return enseignementService.ajouterEnseignement(Enseignement);
    }

    @PutMapping(path = "/enseignement/{id}")
    public Enseignement modifierEnseignement(@RequestBody Enseignement Enseignement, @PathVariable Long id) {
        return enseignementService.modifierEnseignement(Enseignement);
    }

    @DeleteMapping(path = "/enseignement/{id}")
    public ResponseEntity<String> supprimerEnseignement(@PathVariable Long id) {
        enseignementService.suprimerEnseignement(id);
        return new ResponseEntity<>("Enseignement supprimée avec succès", HttpStatus.OK);
    }
}