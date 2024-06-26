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

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.FiliereService;
// import com.uasz.Gestion_DAOS.Service.Maquette.FiliereService;
import com.uasz.Gestion_DAOS.model.Maquette.Filiere;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/maquette")
public class FiliereRestController {

    private FiliereService filiereService;

    @GetMapping(path = "/filiere")
    public List<Filiere> listerFiliere() {
        return filiereService.afficherToutFiliere();
    }

    @GetMapping(path = "/filiere/{id}")
    public Filiere recherchFiliere(@PathVariable Long id) {
        return filiereService.rechercherFiliere(id);
    }

    @PostMapping(path = "/filiere")
    public Filiere ajouterFiliere(@RequestBody Filiere Filiere) {
        return filiereService.ajouterFiliere(Filiere);
    }

    @PutMapping(path = "/filiere/{id}")
    public Filiere modifierFiliere(@RequestBody Filiere Filiere, @PathVariable Long id) {
        return filiereService.modifierFiliere(Filiere);
    }

    @DeleteMapping(path = "/filiere/{id}")
    public ResponseEntity<String> supprimerFiliere(@PathVariable Long id) {
        filiereService.suprimerFiliere(id);
        return new ResponseEntity<>("Filiere supprimée avec succès", HttpStatus.OK);
    }

    @GetMapping(path = "/filiereDetailsFormation/{id}")
    public List<Formation> filiereDetailsFormation(@PathVariable Long id) {
        return filiereService.filiereDetailsFormation(id);
    }
}