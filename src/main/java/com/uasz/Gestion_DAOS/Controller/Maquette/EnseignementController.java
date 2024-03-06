package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
// import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ClasseService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.EnseignementService;
// import com.uasz.Gestion_DAOS.model.Maquette.EC;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;

@Controller
public class EnseignementController {

    @Autowired
    private EnseignementService enseignementService;

    // @Autowired
    // private ClasseService classeService;

    @RequestMapping(value = "/enseignement", method = RequestMethod.GET)
    public String lister_enseignement(Model model) {
        List<Enseignement> enseignementList = enseignementService.afficherToutEnseignement();
        model.addAttribute("listeDesEnseignement", enseignementList);
        return "enseignement";
    }

    @RequestMapping(value = "/ajouter_enseignement", method = RequestMethod.POST)
    public String ajouter_enseignement(Model modele, Enseignement enseignement) {
        enseignementService.ajouterEnseignement(enseignement);
        return "redirect:/enseignement";
    }

    @RequestMapping(value = "/supprimer_ens_classe", method = RequestMethod.GET)
    public String supprimer_ens_classe(Model modele, @RequestParam(name = "id") Long idEns,
            @RequestParam(name = "id2") Long idClasse) {
        enseignementService.suprimerEnseignement(idEns);
        return "redirect:/ens_classe?id=" + idClasse;

    }

    // @RequestMapping(value = "/ajouter_ens", method = RequestMethod.POST)
    // public String ajouter_ens(Model modele, Enseignement ens, @RequestParam(name
    // = "idc") Long idClasse) {
    // ens.setClasse(classeService.rechercherClasse(idClasse));
    // enseignementService.ajouterEnseignement(ens);
    // return "redirect:/ens_classe?id=" + idClasse;
    // }
}