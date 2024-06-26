package com.uasz.Gestion_DAOS.RestController.Maquette;

import java.util.List;

import java.util.stream.Collectors;

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

// import com.uasz.Gestion_DAOS.Service.Maquette.EnseignementService;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;

import com.uasz.Gestion_DAOS.Service.Mapper;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.EnseignementService;
// import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.EnseignementDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/maquette")
@AllArgsConstructor
public class EnseignementRestController {

    private EnseignementService enseignementService;

    // @GetMapping(path = "/enseignement")
    // public List<Enseignement> listerEnseignement() {
    //     return enseignementService.afficherToutEnseignement();
    // }


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