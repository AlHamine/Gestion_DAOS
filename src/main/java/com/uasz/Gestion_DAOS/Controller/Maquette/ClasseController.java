package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Maquette.ClasseService;
import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;

@Controller
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @RequestMapping(value = "/classe", method = RequestMethod.GET)
    public String lister_classe(Model model) {
        List<Classe> classeList = classeService.afficherToutClasse();
        model.addAttribute("listeDesClasse", classeList);
        return "classe";
    }

    @RequestMapping(value = "/ajouter_classe", method = RequestMethod.POST)
    public String ajouter_classe(Model modele, Classe classe) {
        classeService.ajouterClasse(classe);
        return "redirect:/classe";
    }

    @RequestMapping(value = "/supprimerClasse", method = RequestMethod.GET)
    public String supprimerClasse(Model modele, Long id) {
        classeService.suprimerClasse(id);
        return "redirect:/classe";
    }

    @RequestMapping(value = "/ens_classe", method = RequestMethod.GET)
    public String enseignement_classe(Model model, Long id) {
        List<Enseignement> enseignementList = classeService.enseignements_classe(id);
        // System.out.println("+++++++++++++++++++++++++++++++++++++++++>>>>>>>>>>>>>" +
        // enseignementList);
        model.addAttribute("classe", classeService.rechercherClasse(id));
        model.addAttribute("listeDesEnseignement", enseignementList);
        return "classe_ens";
    }

}