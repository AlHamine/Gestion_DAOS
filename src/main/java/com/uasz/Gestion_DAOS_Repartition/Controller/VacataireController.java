package com.uasz.Gestion_DAOS_Repartition.Controller;

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

import com.uasz.Gestion_DAOS_Repartition.Service.VacataireService;
import com.uasz.Gestion_DAOS_Repartition.model.Vacataire;

@RestController
@RequestMapping("/vacataire")
public class VacataireController {

    @Autowired
    private VacataireService vacataireService;

    @GetMapping(path = "/vacataire")
    public List<Vacataire> listerVacataire() {
        return vacataireService.afficherToutVacataire();
    }

    @GetMapping(path = "/vacataire/{id}")
    public Vacataire recherchVacataire(@PathVariable Long id) {
        return vacataireService.rechercherVacataire(id);
    }

    @PostMapping(path = "/vacataire")
    public Vacataire ajouterVacataire(@RequestBody Vacataire Vacataire) {
        return vacataireService.ajouterVacataire(Vacataire);
    }

    @PutMapping(path = "/vacataire/{id}")
    public Vacataire modifierVacataire(@RequestBody Vacataire Vacataire, @PathVariable Long id) {
        return vacataireService.modifierVacataire(Vacataire);
    }

    @DeleteMapping(path = "/vacataire/{id}")
    public ResponseEntity<String> supprimerVacataire(@PathVariable Long id) {
        vacataireService.suprimerVacataire(id);
        return new ResponseEntity<>("Vacataire supprimée avec succès", HttpStatus.OK);
    }
}