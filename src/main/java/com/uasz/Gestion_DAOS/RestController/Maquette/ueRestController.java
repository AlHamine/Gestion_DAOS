package com.uasz.Gestion_DAOS.RestController.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS.Service.Maquette.UEService;
import com.uasz.Gestion_DAOS.model.Maquette.UE;

@RestController
@RequestMapping("/maquette")
// @RequiredArgsConstructor
public class ueRestController {

    @Autowired
    private UEService ueService;

    @GetMapping(path = "/ue")
    public List<UE> listerUe() {
        return ueService.afficherToutUE();
    }

    @GetMapping(path = "/ue/{id}")
    public UE recherch_ue(@PathVariable Long id) {
        return ueService.rechercherUE(id);
    }

    @PostMapping(path = "/ue")
    public UE ajouter_ue(@RequestBody UE ue) {
        return ueService.ajouterUE(ue);
    }

    @PutMapping(path = "/ue/{id}")
    public UE modifier_ue(@RequestBody UE ue, @PathVariable Long id) {
        return ueService.modifierUE(ue);
    }

    // @DeleteMapping(path = "/ue/{id}")
    // public void supprimer_ue(@PathVariable Long id) {
    // ueService.suprimerUE(id);
    // }

    @DeleteMapping(path = "/ue/{id}")
    public ResponseEntity<String> supprimer_ue(@PathVariable Long id) {
        ueService.suprimerUE(id);
        return new ResponseEntity<>("UE supprimée avec succès", HttpStatus.OK);
    }

 

}
