package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.CycleService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.NiveauService;
import com.uasz.Gestion_DAOS.model.Maquette.Niveau;

@Controller
public class NiveauController {

    @Autowired
    private NiveauService niveauService;

    @Autowired
    private CycleService cycleService;

    @RequestMapping(value = "/niveau", method = RequestMethod.GET)
    public String lister_niveau(Model model) {
        List<Niveau> niveauList = niveauService.afficherToutNiveau();
        model.addAttribute("listeDesNiveauX", niveauList);
        return "niveau";
    }

    // @RequestMapping(value = "/ajouter_niveau", method = RequestMethod.POST)
    // public String ajouter_niveau(Model modele, Niveau niveau) {
    // niveauService.ajouterNiveau(niveau);
    // return "redirect:/niveau";
    // }

    @RequestMapping(value = "/supprimer_niveau", method = RequestMethod.GET)
    public String supprimer_niveau(Model modele, @RequestParam(name = "niveauId") Long niveauId,
            @RequestParam(name = "cycleId") Long cycleId) {
        niveauService.suprimerNiveau(niveauId);
        return "redirect:/details_cycle?id=" + cycleId;
    }

    // @RequestMapping(value = "/modifier_niveau", method = RequestMethod.GET)
    // public String modifier_niveau(Model modele, @RequestParam(name = "niveauId")
    // Long niveauId, @RequestParam(name = "cycleId") Long cycleId) {
    // niveauService.suprimerNiveau(niveauId);
    // return "redirect:/details_cycle?id=" + cycleId;
    // }

    @RequestMapping(value = "/ajouter_niveau", method = RequestMethod.POST)
    public String ajouterNiveau(Model model, Niveau niveau, @RequestParam(name = "idcycle") Long cycleId) {
        niveau.setCycle(cycleService.rechercherCycle(cycleId));
        niveauService.ajouterNiveau(niveau);
        // System.out.println("++++++++++ => " + niveau.getId());
        return "redirect:/details_cycle?id=" + cycleId;
    }

    // @RequestMapping(value = "/details_niveau_formation", method = RequestMethod.GET)
    // public String detailsNiveauFormation(Model model, @RequestParam(name = "niveauId") Long niveauId) {
    //     model.addAttribute("niveau", niveauService.rechercherNiveau(niveauId));
    //     model.addAttribute("lesformationsDuNiveaux", niveauService.detailsFormationsDuNiveaux(niveauId));
    //     return "niveau_details";
    // }
}
