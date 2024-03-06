package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.MaquetteService;
import com.uasz.Gestion_DAOS.model.Maquette.Maquette;


@Controller
public class MaquetteController {

    @Autowired
    private MaquetteService maquetteService;

    @RequestMapping(value = "/maquette", method = RequestMethod.GET)
    public String lister_maquette(Model model) {
        List<Maquette> maquetteList = maquetteService.afficherToutMaquette();
        model.addAttribute("listeDesMaquette", maquetteList);
        return "maquette";
    }

    @RequestMapping(value = "/ajouter_maquette", method = RequestMethod.POST)
    public String ajouter_maquette(Model modele, Maquette maquette) {
        maquetteService.ajouterMaquette(maquette);
        return "redirect:/maquette";
    }

}