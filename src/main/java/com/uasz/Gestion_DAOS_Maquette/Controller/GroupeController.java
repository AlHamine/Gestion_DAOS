package com.uasz.Gestion_DAOS_Maquette.Controller;

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

import com.uasz.Gestion_DAOS_Maquette.Service.GroupeService;
import com.uasz.Gestion_DAOS_Maquette.model.Groupe;

@RestController
@RequestMapping("/maquette")
public class GroupeController {

    @Autowired
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
}