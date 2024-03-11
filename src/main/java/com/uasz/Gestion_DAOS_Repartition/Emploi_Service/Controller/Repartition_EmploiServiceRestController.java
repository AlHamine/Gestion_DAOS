package com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Model.Repartition_Emploi;
import com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Service.Repartition_EmploiService;

@RestController
@RequestMapping("/repartition/api")
public class Repartition_EmploiServiceRestController {
    @Autowired
    private Repartition_EmploiService enseignement_RepartitionService;

    @GetMapping("/Repartitions_Emploi")
    public List<Repartition_Emploi> lister_Repartition_Emplois() {
        return enseignement_RepartitionService.lister_Repartition_Emplois();

    }

    // @GetMapping("/enseignements_Repartitions/{id}")
    // public Enseignement_Repartition rechercherEnseignement_Repartition(@PathVariable Long id) {
    //     return enseignement_RepartitionService.rechercherEnseignement_Repartition(id);

    // }
}
