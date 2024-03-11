package com.uasz.Gestion_DAOS_EmploiDuTemps.RepartitionService.Interface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uasz.Gestion_DAOS_EmploiDuTemps.RepartitionService.model.Enseignant;
import com.uasz.Gestion_DAOS_EmploiDuTemps.RepartitionService.model.Repartition;

@FeignClient(name = "repartition-service", url = "http://localhost:8080")
public interface RepartitionProxy {
    @GetMapping(path = "/repartition/api/Repartitions_Emploi")
    List<Repartition> lister_seance_Repartitions();
// List<Enseignant> 
    // @GetMapping("/repartition/api/enseignements_Repartition/{id}")
    // Repartition rechercher_seance_Repartitions(@PathVariable Long id);

    // @DeleteMapping("/maquette/enseignement/{id}")
    // public Boolean supprimerEnseignement(@PathVariable Long id);
    // // @PatchMapping()

}
