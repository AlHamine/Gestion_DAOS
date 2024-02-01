package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Maquette.FormationService;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;


@Controller
public class FormationController {

    @Autowired
    private FormationService formationService;

    @RequestMapping(value = "/formation", method = RequestMethod.GET)
    public String lister_formation(Model model) {
        List<Formation> formationList = formationService.afficherToutFormation();
        model.addAttribute("listeDesFormation", formationList);
        return "formation";
    }

    @RequestMapping(value = "/ajouter_formation", method = RequestMethod.POST)
    public String ajouter_formation(Model modele, Formation formation) {
        formationService.ajouterFormation(formation);
        return "redirect:/formation";
    }

}