package com.uasz.Gestion_DAOS.Controller.Emploie_Du_Temps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.DeroulementService;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Deroulement;


@Controller
public class DeroulementController {

    @Autowired
    private DeroulementService deroulementService;

    @RequestMapping(value = "/deroulement", method = RequestMethod.GET)
    public String lister_deroulement(Model model) {
        List<Deroulement> deroulementList = deroulementService.afficherToutDeroulement();
        model.addAttribute("listeDesDeroulement", deroulementList);
        return "deroulement";
    }

    @RequestMapping(value = "/ajouter_deroulement", method = RequestMethod.POST)
    public String ajouter_deroulement(Model modele, Deroulement deroulement) {
        deroulementService.ajouterDeroulement(deroulement);
        return "redirect:/deroulement";
    }

}