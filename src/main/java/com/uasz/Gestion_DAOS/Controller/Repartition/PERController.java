package com.uasz.Gestion_DAOS.Controller.Repartition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Repartition.PERService;
import com.uasz.Gestion_DAOS.model.Repartition.PER;


@Controller
public class PERController {

    @Autowired
    private PERService perService;

    @RequestMapping(value = "/per", method = RequestMethod.GET)
    public String lister_per(Model model) {
        List<PER> perList = perService.afficherToutPER();
        model.addAttribute("listeDesPER", perList);
        return "per";
    }

    @RequestMapping(value = "/ajouter_per", method = RequestMethod.POST)
    public String ajouter_per(Model modele, PER per) {
        perService.ajouterPER(per);
        return "redirect:/per";
    }

}