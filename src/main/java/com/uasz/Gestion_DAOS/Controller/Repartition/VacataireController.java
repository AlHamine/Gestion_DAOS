package com.uasz.Gestion_DAOS.Controller.Repartition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Repartition.VacataireService;
import com.uasz.Gestion_DAOS.model.Repartition.Vacataire;



@Controller
public class VacataireController {

    @Autowired
    private VacataireService vacataireService;

    @RequestMapping(value = "/vacataire", method = RequestMethod.GET)
    public String lister_vacataire(Model model) {
        List<Vacataire> vacataireList = vacataireService.afficherToutVacataire();
        model.addAttribute("listeDesVacataire", vacataireList);
        return "vacataire";
    }

    @RequestMapping(value = "/ajouter_vacataire", method = RequestMethod.POST)
    public String ajouter_vacataire(Model modele, Vacataire vacataire) {
        vacataireService.ajouterVacataire(vacataire);
        return "redirect:/vacataire";
    }

}