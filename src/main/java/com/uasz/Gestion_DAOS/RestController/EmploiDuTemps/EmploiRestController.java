package com.uasz.Gestion_DAOS.RestController.EmploiDuTemps;

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

import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.EmploiService;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Emploi;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.EmploiDTO;

@RestController
@RequestMapping("/emploi")
public class EmploiRestController {

    @Autowired
    private EmploiService emploiService;

    @GetMapping(path = "/emploi")
    public List<EmploiDTO> listerEmploi() {
        return emploiService.afficherToutEmploi().stream().map(s -> new EmploiDTO(s)).collect(Collectors.toList());
    }

    @GetMapping(path = "/emploi/{id}")
    public EmploiDTO recherchEmploi(@PathVariable Long id) {
        return new EmploiDTO(emploiService.rechercherEmploi(id));
    }

    @PostMapping(path = "/emploi")
    public Emploi ajouterEmploi(@RequestBody Emploi Emploi) {
        return emploiService.ajouterEmploi(Emploi);
    }

    @PutMapping(path = "/emploi/{id}")
    public Emploi modifierEmploi(@RequestBody Emploi Emploi, @PathVariable Long id) {
        return emploiService.modifierEmploi(Emploi);
    }

    @DeleteMapping(path = "/emploi/{id}")
    public ResponseEntity<String> supprimerEmploi(@PathVariable Long id) {
        emploiService.suprimerEmploi(id);
        return new ResponseEntity<>("Emploi supprimée avec succès", HttpStatus.OK);
    }
}