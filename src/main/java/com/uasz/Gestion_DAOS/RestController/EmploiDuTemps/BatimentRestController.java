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
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.BatimentService;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Batiment;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.BatimentDTO;

@RestController
@RequestMapping("/emploi")
public class BatimentRestController {

    @Autowired
    private BatimentService batimentService;

    // @GetMapping(path = "/batiment")
    // public List<Batiment> listerBatiment() {
    // return batimentService.afficherToutBatiment();
    // }
    @GetMapping(path = "/batiment")
    public List<BatimentDTO> listerBatiment() {
        return batimentService.afficherToutBatiment().stream().map(utilisateur -> Mapper.mapBatimentToDTO(utilisateur))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/batiment/{id}")
    public BatimentDTO recherchBatiment(@PathVariable Long id) {
        return Mapper.mapBatimentToDTO(batimentService.rechercherBatiment(id));
    }

    @PostMapping(path = "/batiment")
    public Batiment ajouterBatiment(@RequestBody Batiment Batiment) {
        return batimentService.ajouterBatiment(Batiment);
    }

    @PutMapping(path = "/batiment/{id}")
    public Batiment modifierBatiment(@RequestBody Batiment Batiment, @PathVariable Long id) {
        return batimentService.modifierBatiment(Batiment);
    }

    @DeleteMapping(path = "/batiment/{id}")
    public ResponseEntity<String> supprimerBatiment(@PathVariable Long id) {
        batimentService.suprimerBatiment(id);
        return new ResponseEntity<>("Batiment supprimée avec succès", HttpStatus.OK);
    }
}