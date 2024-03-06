package com.uasz.Gestion_DAOS.RestController.Repartition;

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

import com.uasz.Gestion_DAOS.Service.Mapper;
import com.uasz.Gestion_DAOS.Service.Repartition.EnseignantService;
import com.uasz.Gestion_DAOS.model.Repartition.Enseignant;
import com.uasz.Gestion_DAOS.model.Repartition.EnseignantDTO;
import com.uasz.Gestion_DAOS.model.Repartition.Vacataire;

@RestController
@RequestMapping("/repartition")
public class EnseignantRestController {

    @Autowired
    private EnseignantService enseignantService;

    @GetMapping(path = "/enseignant")
    public List<EnseignantDTO> listerEnseignant() {
        return enseignantService.afficherToutEnseignant().stream().map(e -> {
            if (e instanceof Vacataire)
                return Mapper.mapVacataireDTO(e);
            return Mapper.mapPerdto(e);

        }).collect(Collectors.toList());
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