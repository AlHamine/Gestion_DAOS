package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.FiliereService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.FormationService;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;


@Controller
public class FormationController {

    @Autowired
    private FormationService formationService;

    @Autowired
    private FiliereService filiereService;

    @RequestMapping(value = "/formation", method = RequestMethod.GET)
    public String lister_formation(Model model) {
        List<Formation> formationList = formationService.afficherToutFormation();
        model.addAttribute("listeDesFormation", formationList);
        return "formation";
    }

    @RequestMapping(value = "/ajouter_formation", method = RequestMethod.POST)
    public String ajouterFormation(Model model, Formation formation, @RequestParam(name = "filiereId") Long filiereId) {
        formation.setFiliere(filiereService.rechercherFiliere(filiereId));
        formationService.ajouterFormation(formation);
        return "redirect:/details_filiere?filiereId=" + filiereId;
        
    }

    @RequestMapping(value = "/supprimer_formation", method = RequestMethod.GET)
    public String supprimer_formation(Model modele, @RequestParam(name = "formationId") Long formationId, @RequestParam(name = "filiereId") Long filiereId) {
        formationService.suprimerFormation(formationId);
        return "redirect:/details_filiere?filiereId=" + filiereId;
    }

    @RequestMapping(value = "/detailsFormationNiveau", method = RequestMethod.GET)
    public String detailsFormationNiveau(Model model, @RequestParam(name = "formationId") Long formationId) {
        model.addAttribute("formation", formationService.rechercherFormation(formationId));
        model.addAttribute("leNiveauDuFormation", formationService.detailsFormationNiveau(formationId));
        return "formation_details";
    }

}