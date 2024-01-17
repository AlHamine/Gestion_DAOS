package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Service.Maquette.ClasseService;
import com.uasz.Gestion_DAOS.Service.Maquette.GroupeService;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.Groupe;

@Controller
public class GroupeController {

    @Autowired
    private GroupeService groupeService;

    @Autowired
    private ClasseService cService;

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

    @RequestMapping(value = "/supprimer_groupe_classe", method = RequestMethod.GET)
    public String supprimer_groupe_classe(Model modele, @RequestParam(name = "id") Long idGroupe,
            @RequestParam(name = "id2") Long idClasse) {
        groupeService.suprimerGroupe(idGroupe);
        return "redirect:/groupe_classe?id=" + idClasse;
    }

    @RequestMapping(value = "/ajouter_groupe_classe", method = RequestMethod.POST)
    public String ajouter_groupe_classe(Model modele, Groupe g, @RequestParam(name = "idc") Long idClasse) {
        g.setClasse(cService.rechercherClasse(idClasse));
        groupeService.ajouterGroupe(g);
        return "redirect:/groupe_classe?id=" + idClasse;
        // return "redirect:/groupe";
    }

}