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

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ModuleService;
import com.uasz.Gestion_DAOS.model.Maquette.Module;

@RestController
@RequestMapping("/maquette")
public class ModuleRestController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping(path = "/module")
    public List<Module> listerModule() {
        return moduleService.afficherToutModule();
    }

    @GetMapping(path = "/module/{id}")
    public Module recherchModule(@PathVariable Long id) {
        return moduleService.rechercherModule(id);
    }

    @PostMapping(path = "/module")
    public Module ajouterModule(@RequestBody Module Module) {
        return moduleService.ajouterModule(Module);
    }

    @PutMapping(path = "/module/{id}")
    public Module modifierModule(@RequestBody Module Module, @PathVariable Long id) {
        return moduleService.modifierModule(Module);
    }

    @DeleteMapping(path = "/module/{id}")
    public ResponseEntity<String> supprimerModule(@PathVariable Long id) {
        moduleService.suprimerModule(id);
        return new ResponseEntity<>("Module supprimée avec succès", HttpStatus.OK);
    }
}