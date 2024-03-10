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

import com.uasz.Gestion_DAOS.Service.Maquette.ClasseService;
import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.Groupe;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/maquette")
@AllArgsConstructor
public class ClasseRestController {

    private ClasseService classeService;

    @GetMapping(path = "/classe")
    public List<Classe> listerClasse() {
        return classeService.afficherToutClasse();
    }

    @GetMapping(path = "/classe/{id}")
    public Classe recherchClasse(@PathVariable Long id) {
        return classeService.rechercherClasse(id);
    }

    @PostMapping(path = "/classe")
    public Classe ajouterClasse(@RequestBody Classe Classe) {
        return classeService.ajouterClasse(Classe);
    }

    @PutMapping(path = "/classe/{id}")
    public Classe modifierClasse(@RequestBody Classe Classe, @PathVariable Long id) {
        return classeService.modifierClasse(Classe);
    }

    @DeleteMapping(path = "/classe/{id}")
    public ResponseEntity<String> supprimerClasse(@PathVariable Long id) {
        classeService.suprimerClasse(id);
        return new ResponseEntity<>("Classe supprimée avec succès", HttpStatus.OK);
    }

    @GetMapping(path = "/classeDetailsGroupe/{id}")
    public List<Groupe> classeDetailsGroupe(@PathVariable Long id) {
        return classeService.classeDetailsGroupe(id);
    }

    @GetMapping(path = "/classeDetailsEnseignement/{id}")
    public List<Enseignement> classeDetailsEnseignement(@PathVariable Long id) {
        return classeService.classeDetailsEnseignement(id);
    }
}