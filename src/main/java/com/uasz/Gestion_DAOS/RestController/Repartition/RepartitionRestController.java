package com.uasz.Gestion_DAOS.RestController.Repartition;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS.Service.Mapper;
import com.uasz.Gestion_DAOS.Service.Repartition.RepartitionService;
import com.uasz.Gestion_DAOS.model.Repartition.Repartition;
import com.uasz.Gestion_DAOS.model.Repartition.RepartitionDTO;

@RestController
@RequestMapping("/repartition")
public class RepartitionRestController {
    @Autowired
    private RepartitionService repartitionService;

    @GetMapping(path = "/repartition")
    public List<RepartitionDTO> listerRepartition() {
        return repartitionService.afficherToutRepartition().stream().map(r -> Mapper.mRepartitionDTO(r))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/repartition/{id}")
    public RepartitionDTO recherchRepartition(@PathVariable Long id) {
        return Mapper.mRepartitionDTO(repartitionService.rechercherRepartition(id));
    }

    @PostMapping(path = "/repartition")
    public Repartition ajouterRepartition(@RequestBody Repartition Repartition) {
        return repartitionService.ajouterRepartition(Repartition);
    }

    // @PatchMapping(path = "/repartition/{id}/{idEnseignant}/{idEnseignement}")
    // public Repartition modifierRepartition(@RequestBody Repartition Repartition, @PathVariable Long id,
    //         @PathVariable Long idEnseignant, @PathVariable Long idEnseignement) {
    //     // repartitionService.UpdateRepartition(Repartition, id, idEnseignant,
    //     // idEnseignement);
    //     return null;
    // }
    @PatchMapping(path = "/repartition/{id}")
    public Repartition modifierRepartition(@RequestBody Repartition Repartition,
    @PathVariable Long id) {
    return repartitionService.modifierRepartition(Repartition);
    }

    @DeleteMapping(path = "/repartition/{id}")
    public ResponseEntity<String> supprimerRepartition(@PathVariable Long id) {
        repartitionService.suprimerRepartition(id);
        return new ResponseEntity<>("Repartition supprimée avec succès", HttpStatus.OK);
    }
}
