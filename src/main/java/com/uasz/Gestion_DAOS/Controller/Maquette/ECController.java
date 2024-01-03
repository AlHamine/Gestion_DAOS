package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Service.Maquette.ECService;
import com.uasz.Gestion_DAOS.model.Maquette.EC;

@Controller
public class ECController {

    @Autowired
    private ECService eCService;

    @RequestMapping(value = "/ec", method = RequestMethod.GET)
    public String lister_eC(Model model) {
        List<EC> eCList = eCService.afficherToutEC();
        model.addAttribute("listeDesEC", eCList);
        return "ec";
    }

    @RequestMapping(value = "/ajouter_ec", method = RequestMethod.POST)
    public String ajouter_ec(Model modele, EC ec) {
        eCService.ajouterEC(ec);
        return "redirect:/ec";
    }

    @RequestMapping(value = "/supprimer_ec", method = RequestMethod.GET)
    public String supprimer_ue(Model modele, @RequestParam(name = "id") Long id,
            @RequestParam(name = "id2") Long id2) {

        eCService.suprimerEC(id);
        return "redirect:/details_ue?id=" + id2;
        // return "redirect:/ue";
    }

}