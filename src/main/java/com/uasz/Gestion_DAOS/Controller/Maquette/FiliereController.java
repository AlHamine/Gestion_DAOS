package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Maquette.FiliereService;
import com.uasz.Gestion_DAOS.model.Maquette.Filiere;

/**
 * UEController
 */
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

}