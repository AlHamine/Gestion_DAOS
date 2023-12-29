package com.uasz.Gestion_DAOS.Controller.Emploie_Du_Temps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.SalleService;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Salle;


@Controller
public class SalleController {

    @Autowired
    private SalleService salleService;

    @RequestMapping(value = "/salle", method = RequestMethod.GET)
    public String lister_salle(Model model) {
        List<Salle> salleList = salleService.afficherToutSalle();
        model.addAttribute("listeDesSalle", salleList);
        return "salle";
    }

    @RequestMapping(value = "/ajouter_salle", method = RequestMethod.POST)
    public String ajouter_salle(Model modele, Salle salle) {
        salleService.ajouterSalle(salle);
        return "redirect:/salle";
    }

}