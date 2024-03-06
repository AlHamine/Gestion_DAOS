package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.CycleService;
import com.uasz.Gestion_DAOS.model.Maquette.Cycle;


@Controller
public class CycleController {

    @Autowired
    private CycleService cycleService;

    @RequestMapping(value = "/cycle", method = RequestMethod.GET)
    public String lister_cycle(Model model) {
        List<Cycle> cycleList = cycleService.afficherToutCycle();
        model.addAttribute("listeDesCycle", cycleList);
        return "cycle";
    }

    @RequestMapping(value = "/ajouter_cycle", method = RequestMethod.POST)
    public String ajouter_cycle(Model modele, Cycle cycle) {
        cycleService.ajouterCycle(cycle);
        return "redirect:/cycle";
    }

    @RequestMapping(value = "/supprimer_cycle", method = RequestMethod.GET)
    public String supprimer_cycle(Model modele, @RequestParam(name = "id") Long id) {
        cycleService.suprimerCycle(id);
        return "redirect:/cycle";
    }

    @RequestMapping(value = "/details_cycle", method = RequestMethod.GET)
    public String details_cycle(Model modele, @RequestParam(name = "id") Long id) {
        modele.addAttribute("cycle", cycleService.rechercherCycle(id));
        modele.addAttribute("listeDesNiveau", cycleService.detailsNiveau(id));
        return "cycle_details";
    }
}