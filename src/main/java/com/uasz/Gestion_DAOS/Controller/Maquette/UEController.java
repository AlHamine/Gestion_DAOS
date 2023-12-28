package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Maquette.UEService;
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

    @RequestMapping(value = "/ajouter_ue", method = RequestMethod.POST)
    public String ajouter_ue(Model modele, UE ue) {
        ueService.ajouterUE(ue);
        return "redirect:/ue";
    }

}