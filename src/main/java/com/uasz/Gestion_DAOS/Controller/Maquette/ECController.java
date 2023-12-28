package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Maquette.ECService;
import com.uasz.Gestion_DAOS.model.Maquette.EC;

/**
 * UEController
 */
@Controller
public class ECController {

    @Autowired
    private ECService eCService;

    @RequestMapping(value = "/ec", method = RequestMethod.GET)
    public String lister_eC(Model model) {
        List<EC> eCList = eCService.afficherToutEC();
        model.addAttribute("listeDesEC", eCList);
        return "eC";
    }

    @RequestMapping(value = "/ajouter_ec", method = RequestMethod.POST)
    public String ajouter_ec(Model modele, EC ec) {
        eCService.ajouterEC(ec);
        return "redirect:/ec";
    }

}