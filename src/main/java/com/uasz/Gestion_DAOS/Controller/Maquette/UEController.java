package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.UEService;
import com.uasz.Gestion_DAOS.model.Maquette.UE;

/**
 * UEController
 */
@Controller
public class UEController {

    @Autowired
    private UEService ueService;

    @RequestMapping(value = "/ue", method = RequestMethod.GET)
    public String lister_ue(Model model) {
        List<UE> ueList = ueService.afficherToutUE();
        model.addAttribute("listeDesUE", ueList);
        return "ue";
    }

    // @RequestMapping(value = "/ue", method = RequestMethod.GET)
    // public String lister_ue(Model model, @RequestParam(name = "page",
    // defaultValue = "0") int page, @RequestParam(name = "size", defaultValue =
    // "5") int size) {
    // Page<UE> ueList = ueService.afficherToutUE();
    // model.addAttribute("listeDesUE", ueList);
    // return "ue";
    // }

    @RequestMapping(value = "/ajouter_ue", method = RequestMethod.POST)
    public String ajouter_ue(Model modele, UE ue) {
        ueService.ajouterUE(ue);
        return "redirect:/ue";
    }

    @RequestMapping(value = "/rechercher_id_supprimer", method = RequestMethod.GET)
    public String supprimer_ue(Model modele, @RequestParam(name = "id") Long id) {
        ueService.suprimerUE(id);
        return "redirect:/ue";
    }

    @RequestMapping(value = "/details_ue", method = RequestMethod.GET)
    public String details_ue(Model modele, @RequestParam(name = "id") Long id) {
        modele.addAttribute("ue", ueService.rechercherUE(id));
        modele.addAttribute("listeDesEC", ueService.detailsUE(id));
        return "ue_details";
    }

    @RequestMapping(value = "/ue_modules", method = RequestMethod.GET)
    public String ue_modules(Model modele, @RequestParam(name = "id") Long id) {
        modele.addAttribute("ue", ueService.rechercherUE(id));
        // modele.addAttribute("listeDesModules", ueService.UE_modules(id)); // OLD
        modele.addAttribute("listeDesModules", ueService.detailsModule(id));
        return "ue_modules";
    }

    // @RequestMapping(value = "/form_ajouter_ue", method = RequestMethod.GET)
    // public String form_ajouter_ue(Model modele) {
    // return "ue_add";
    // }

    // @RequestMapping(value = "/rechercher_id_modifier", method =
    // RequestMethod.GET)
    // public String modifier_ue(Model modele, @RequestParam(name = "id") Long id) {
    // // ueService.modifierUE(ue);
    // UE ue = ueService.rechercherUE(id);
    // modele.addAttribute("ue", ue);
    // return "ue_edit";
    // }

    @RequestMapping(value = "/modifier_ue", method = RequestMethod.POST)
    public String modifier_ue(UE ue) {
        ueService.modifierUE(ue);
        return "redirect:/ue";
    }

    // @RequestMapping(value = "/rechercher_id_modifier", method =
    // RequestMethod.PUT)
    // public String enregistrer(Model modele, Long id) {
    // // ueService.modifierUE(ue);
    // return "redirect:/ue";
    // }

}