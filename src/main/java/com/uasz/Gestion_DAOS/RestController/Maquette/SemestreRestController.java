package com.uasz.Gestion_DAOS.RestController.Maquette;

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

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.SemestreService;
import com.uasz.Gestion_DAOS.model.Maquette.Semestre;

@RestController
@RequestMapping("/maquette")
public class SemestreRestController {

    @Autowired
    private SemestreService semestreService;

    @GetMapping(path = "/semestre")
    public List<Semestre> listerSemestre() {
        return semestreService.afficherToutSemestre();
    }

    @GetMapping(path = "/semestre/{id}")
    public Semestre recherchSemestre(@PathVariable Long id) {
        return semestreService.rechercherSemestre(id);
    }

    @PostMapping(path = "/semestre")
    public Semestre ajouterSemestre(@RequestBody Semestre niveau) {
        return semestreService.ajouterSemestre(niveau);
    }

    @PutMapping(path = "/semestre/{id}")
    public Semestre modifierSemestre(@RequestBody Semestre niveau, @PathVariable Long id) {
        return semestreService.modifierSemestre(niveau);
    }

    @DeleteMapping(path = "/semestre/{id}")
    public ResponseEntity<String> supprimerSemestre(@PathVariable Long id) {
        semestreService.suprimerSemestre(id);
        return new ResponseEntity<>("Semestre supprimée avec succès", HttpStatus.OK);
    }
}