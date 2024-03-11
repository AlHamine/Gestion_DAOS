package com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Interface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Model.Enseignement;

@FeignClient(name = "maquette-service", url = "http://localhost:8080")
public interface MaquetteProxy {
    @GetMapping(path = "/maquette/api/enseignements_Repartitions")
    List<Enseignement> lister_enseignements_Repartitions();

    @GetMapping("/maquette/api/enseignements_Repartition/{id}")
    Enseignement rechercher_Enseignement(@PathVariable Long id);
  
    @DeleteMapping("/maquette/enseignement/{id}")
    public Boolean supprimerEnseignement(@PathVariable Long id);
    // @PatchMapping()

}
