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

import com.uasz.Gestion_DAOS.Service.Maquette.GroupeService;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.Groupe;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/maquette")
public class GroupeRestController {

    private GroupeService groupeService;

    @GetMapping(path = "/groupe")
    public List<Groupe> listerGroupe() {
        return groupeService.afficherToutGroupe();
    }

    @GetMapping(path = "/groupe/{id}")
    public Groupe recherchGroupe(@PathVariable Long id) {
        return groupeService.rechercherGroupe(id);
    }

    @PostMapping(path = "/groupe")
    public Groupe ajouterGroupe(@RequestBody Groupe Groupe) {
        return groupeService.ajouterGroupe(Groupe);
    }

    @PutMapping(path = "/groupe/{id}")
    public Groupe modifierGroupe(@RequestBody Groupe Groupe, @PathVariable Long id) {
        return groupeService.modifierGroupe(Groupe);
    }

    @DeleteMapping(path = "/groupe/{id}")
    public ResponseEntity<String> supprimerGroupe(@PathVariable Long id) {
        groupeService.suprimerGroupe(id);
        return new ResponseEntity<>("Groupe supprimée avec succès", HttpStatus.OK);
    }

    @GetMapping(path = "/groupeDetailsEnseignement/{id}")
    public List<Enseignement> groupeDetailsEnseignement(@PathVariable Long id) {
        return groupeService.groupeDetailsEnseignement(id);
    }
}