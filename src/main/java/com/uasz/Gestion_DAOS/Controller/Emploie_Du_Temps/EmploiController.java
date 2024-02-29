package com.uasz.Gestion_DAOS.Controller.Emploie_Du_Temps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.EmploiService;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Emploi;


@Controller
public class EmploiController {

    @Autowired
    private EmploiService emploiService;

    @RequestMapping(value = "/emploi", method = RequestMethod.GET)
    public String lister_emploi(Model model) {
        List<Emploi> emploiList = emploiService.afficherToutEmploi();
        model.addAttribute("listeDesEmploi", emploiList);
        return "emploi";
    }

    @RequestMapping(value = "/ajouter_emploi", method = RequestMethod.POST)
    public String ajouter_emploi(Model modele, Emploi emploi) {
        emploiService.ajouterEmploi(emploi);
        return "redirect:/emploi";
    }

}