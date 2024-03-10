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

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.UEService;
// import com.uasz.Gestion_DAOS.Service.Maquette.UEService;
import com.uasz.Gestion_DAOS.model.Maquette.EC;
import com.uasz.Gestion_DAOS.model.Maquette.UE;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/maquette")
public class UERestController {

    private UEService ueService;

    @GetMapping(path = "/ue")
    public List<UE> listerUE() {
        return ueService.afficherToutUE();
    }

    @GetMapping(path = "/ue/{id}")
    public UE recherchUE(@PathVariable Long id) {
        return ueService.rechercherUE(id);
    }

    @PostMapping(path = "/ue")
    public UE ajouterUE(@RequestBody UE ue) {
        return ueService.ajouterUE(ue);
    }

    @PutMapping(path = "/ue/{id}")
    public UE modifierUE(@RequestBody UE ue, @PathVariable Long id) {
        return ueService.modifierUE(ue);
    }

    @DeleteMapping(path = "/ue/{id}")
    public ResponseEntity<String> supprimerUE(@PathVariable Long id) {
        ueService.suprimerUE(id);
        return new ResponseEntity<>("UE supprimée avec succès", HttpStatus.OK);
    }

    // pour les details de EC
    @GetMapping(path = "/uedetailsEC/{id}")
    public List<EC> ue_detailsEC(@PathVariable Long id) {
        return ueService.detailsUE(id);
    }

    // pour les details de Module
    @GetMapping(path = "/uedetailsModule/{id}")
    public List<com.uasz.Gestion_DAOS.model.Maquette.Module> ue_detailsModule(@PathVariable Long id) {
        return ueService.detailsModule(id);
    }
}