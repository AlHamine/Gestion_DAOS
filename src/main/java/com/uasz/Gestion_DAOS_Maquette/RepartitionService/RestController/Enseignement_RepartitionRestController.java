package com.uasz.Gestion_DAOS_Maquette.RepartitionService.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.Gestion_DAOS_Maquette.RepartitionService.model.Enseignement_Repartition;
import com.uasz.Gestion_DAOS_Maquette.RepartitionService.model.Service.Enseignement_RepartitionService;

@RestController
@RequestMapping("/maquette/api")
public class Enseignement_RepartitionRestController {
    @Autowired
    private Enseignement_RepartitionService enseignement_RepartitionService;

    @GetMapping("/enseignements_Repartitions")
    public List<Enseignement_Repartition> lister_Enseignement() {
        return enseignement_RepartitionService.lister_Enseignement_Repartition();

    }
}
