package com.uasz.Gestion_DAOS.RestController.Repartition;

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
import com.uasz.Gestion_DAOS.Service.Repartition.VacataireService;
import com.uasz.Gestion_DAOS.model.Repartition.Vacataire;
import com.uasz.Gestion_DAOS.model.Repartition.VacataireDTO;

@RestController
@RequestMapping("/repartition")
// @RequiredArgsConstructor
public class VacataireRestController {
    @Autowired
    private VacataireService vacataireService;

    @GetMapping(path = "/vacataire")
    public List<VacataireDTO> listerVacataire() {
        return vacataireService.afficherToutVacataire().stream().map(p -> Mapper.mapVacataireDTO(p))
                .collect(Collectors.toList());
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
        return new ResponseEntity<>("vacataire supprimée avec succès", HttpStatus.OK);
    }
}
