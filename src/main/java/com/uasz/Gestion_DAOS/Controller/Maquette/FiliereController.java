package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.FiliereService;
import com.uasz.Gestion_DAOS.model.Maquette.Filiere;


@Controller
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @RequestMapping(value = "/filiere", method = RequestMethod.GET)
    public String lister_filiere(Model model) {
        List<Filiere> filiereList = filiereService.afficherToutFiliere();
        model.addAttribute("listeDesFiliere", filiereList);
        return "filiere";
    }

    @RequestMapping(value = "/ajouter_filiere", method = RequestMethod.POST)
    public String ajouter_filiere(Model modele, Filiere filiere) {
        filiereService.ajouterFiliere(filiere);
        return "redirect:/filiere";
    }

    @RequestMapping(value = "/supprimer_filiere", method = RequestMethod.GET)
    public String supprimer_cycle(Model modele, @RequestParam(name = "filiereId") Long id) {
        filiereService.suprimerFiliere(id);
        return "redirect:/filiere";
    }

    @RequestMapping(value = "/details_filiere", method = RequestMethod.GET)
    public String details_filiere(Model model, @RequestParam(name = "filiereId") Long filiereId) {
        model.addAttribute("filiere", filiereService.rechercherFiliere(filiereId));
        model.addAttribute("listeDesFormation", filiereService.detailsFormation(filiereId));
        return "filiere_details";
    }

}