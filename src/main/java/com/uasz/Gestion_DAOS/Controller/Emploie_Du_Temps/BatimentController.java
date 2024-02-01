package com.uasz.Gestion_DAOS.Controller.Emploie_Du_Temps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.BatimentService;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Batiment;


@Controller
public class BatimentController {

    @Autowired
    private BatimentService batimentService;

    @RequestMapping(value = "/batiment", method = RequestMethod.GET)
    public String lister_batiment(Model model) {
        List<Batiment> batimentList = batimentService.afficherToutBatiment();
        model.addAttribute("listeDesBatiment", batimentList);
        return "batiment";
    }

    @RequestMapping(value = "/ajouter_batiment", method = RequestMethod.POST)
    public String ajouter_batiment(Model modele, Batiment batiment) {
        batimentService.ajouterBatiment(batiment);
        return "redirect:/batiment";
    }

}