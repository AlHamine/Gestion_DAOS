package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Maquette.EnseignementService;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;


@Controller
public class EnseignementController {

    @Autowired
    private EnseignementService enseignementService;

    @RequestMapping(value = "/enseignement", method = RequestMethod.GET)
    public String lister_enseignement(Model model) {
        List<Enseignement> enseignementList = enseignementService.afficherToutEnseignement();
        model.addAttribute("listeDesEnseignement", enseignementList);
        return "enseignement";
    }

    @RequestMapping(value = "/ajouter_enseignement", method = RequestMethod.POST)
    public String ajouter_enseignement(Model modele, Enseignement enseignement) {
        enseignementService.ajouterEnseignement(enseignement);
        return "redirect:/enseignement";
    }



}