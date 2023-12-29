package com.uasz.Gestion_DAOS.Controller.Repartition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Repartition.EnseignantService;
import com.uasz.Gestion_DAOS.model.Repartition.Enseignant;


@Controller
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    @RequestMapping(value = "/enseignant", method = RequestMethod.GET)
    public String lister_enseignant(Model model) {
        List<Enseignant> enseignantList = enseignantService.afficherToutEnseignant();
        model.addAttribute("listeDesEnseignant", enseignantList);
        return "enseignant";
    }

    @RequestMapping(value = "/ajouter_enseignant", method = RequestMethod.POST)
    public String ajouter_enseignant(Model modele, Enseignant enseignant) {
        enseignantService.ajouterEnseignant(enseignant);
        return "redirect:/enseignant";
    }

}