package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Maquette.GroupeService;
import com.uasz.Gestion_DAOS.model.Maquette.Groupe;

/**
 * UEController
 */
@Controller
public class GroupeController {

    @Autowired
    private GroupeService groupeService;

    @RequestMapping(value = "/groupe", method = RequestMethod.GET)
    public String lister_groupe(Model model) {
        List<Groupe> groupeList = groupeService.afficherToutGroupe();
        model.addAttribute("listeDesGroupe", groupeList);
        return "groupe";
    }

    @RequestMapping(value = "/ajouter_groupe", method = RequestMethod.POST)
    public String ajouter_groupe(Model modele, Groupe groupe) {
        groupeService.ajouterGroupe(groupe);
        return "redirect:/groupe";
    }

}