package com.uasz.Gestion_DAOS.Controller.Emploie_Du_Temps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.SeanceService;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Seance;


@Controller
public class SeanceController {

    @Autowired
    private SeanceService seanceService;

    @RequestMapping(value = "/seance", method = RequestMethod.GET)
    public String lister_seance(Model model) {
        List<Seance> seanceList = seanceService.afficherToutSeance();
        model.addAttribute("listeDesSeance", seanceList);
        return "seance";
    }

    @RequestMapping(value = "/ajouter_seance", method = RequestMethod.POST)
    public String ajouter_seance(Model modele, Seance seance) {
        seanceService.ajouterSeance(seance);
        return "redirect:/seance";
    }

}