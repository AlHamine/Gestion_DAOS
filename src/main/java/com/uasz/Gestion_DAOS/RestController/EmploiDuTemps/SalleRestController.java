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

import com.uasz.Gestion_DAOS.Service.Mapper;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.SalleService;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Salle;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.SalleDTO;

@RestController
@RequestMapping("/emploi")
public class SalleRestController {

    @Autowired
    private SalleService salleService;

    // @GetMapping(path = "/salle")
    // public List<Salle> listerSalle() {
    // return salleService.afficherToutSalle();
    // }
    @GetMapping(path = "/salle")
    public List<SalleDTO> listerSalle() {
        return salleService.afficherToutSalle().stream().map(salle -> Mapper.mapSalleToDTO(salle))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/batiment/{batimentId}/salles")
    public List<SalleDTO> SalleBatiment(@PathVariable Long batimentId) {
        return salleService.afficherSalleSelonBatiment(batimentId).stream().map(salle -> Mapper.mapSalleToDTO(salle))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/salle/{id}")
    public SalleDTO recherchSalle(@PathVariable Long id) {
        return Mapper.mapSalleToDTO(salleService.rechercherSalle(id));
    }

    @PostMapping(path = "/salle")
    public Salle ajouterSalle(@RequestBody Salle Salle) {
        return salleService.ajouterSalle(Salle);
    }

    @PutMapping(path = "/salle/{id}")
    public Salle modifierSalle(@RequestBody Salle Salle, @PathVariable Long id) {
        return salleService.modifierSalle(Salle);
    }

    @DeleteMapping(path = "/salle/{id}")
    public ResponseEntity<String> supprimerSalle(@PathVariable Long id) {
        salleService.suprimerSalle(id);
        return new ResponseEntity<>("Salle supprimée avec succès", HttpStatus.OK);
    }
}