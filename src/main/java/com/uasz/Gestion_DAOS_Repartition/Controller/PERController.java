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

import com.uasz.Gestion_DAOS_Repartition.Service.PERService;
import com.uasz.Gestion_DAOS_Repartition.model.PER;

@RestController
@RequestMapping("/repartition")
public class PERController {

    @Autowired
    private PERService perService;

    @GetMapping(path = "/per")
    public List<PER> listerPER() {
        return perService.afficherToutPER();
    }

    @GetMapping(path = "/per/{id}")
    public PER recherchPER(@PathVariable Long id) {
        return perService.rechercherPER(id);
    }

    @PostMapping(path = "/per")
    public PER ajouterPER(@RequestBody PER PER) {
        return perService.ajouterPER(PER);
    }

    @PutMapping(path = "/per/{id}")
    public PER modifierPER(@RequestBody PER PER, @PathVariable Long id) {
        return perService.modifierPER(PER);
    }

    @DeleteMapping(path = "/per/{id}")
    public ResponseEntity<String> supprimerPER(@PathVariable Long id) {
        perService.suprimerPER(id);
        return new ResponseEntity<>("PER supprimée avec succès", HttpStatus.OK);
    }
}