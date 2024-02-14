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

import com.uasz.Gestion_DAOS_Maquette.Service.UEService;
import com.uasz.Gestion_DAOS_Maquette.model.UE;

@RestController
@RequestMapping("/maquette")
public class UEController {

    @Autowired
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
}
