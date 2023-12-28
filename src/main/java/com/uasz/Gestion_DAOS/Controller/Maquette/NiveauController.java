package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Maquette.NiveauService;
import com.uasz.Gestion_DAOS.model.Maquette.Niveau;

/**
 * UEController
 */
@Controller
public class NiveauController {

    @Autowired
    private NiveauService niveauService;

    @RequestMapping(value = "/niveau", method = RequestMethod.GET)
    public String lister_niveau(Model model) {
        List<Niveau> niveauList = niveauService.afficherToutNiveau();
        model.addAttribute("listeDesNiveau", niveauList);
        return "niveau";
    }

    @RequestMapping(value = "/ajouter_niveau", method = RequestMethod.POST)
    public String ajouter_niveau(Model modele, Niveau niveau) {
        niveauService.ajouterNiveau(niveau);
        return "redirect:/niveau";
    }

}